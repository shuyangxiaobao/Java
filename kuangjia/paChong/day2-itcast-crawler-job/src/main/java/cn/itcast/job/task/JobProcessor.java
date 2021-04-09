package cn.itcast.job.task;

import cn.itcast.job.pojo.JobInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.UUID;

@Component
public class JobProcessor implements PageProcessor {

    private String url = "https://www.lagou.com/shanghai-zhaopin/Java/?labelWords=label";

    @Override
    public void process(Page page) {
        //解析页面，获取招聘信息详情的url地址
        Html pageHtml = page.getHtml ();
        List<Selectable> list = pageHtml.css ( "div.s_position_list > ul.item_con_list > li" ).nodes ();


        //判断获取到的集合是否为空
        if (list.size () == 0) {
            // 如果为空，表示这是招聘详情页,解析页面，获取招聘详情信息，保存数据

         new Thread ( new Runnable () {
             @Override
             public void run() {
                 saveJobInfo ( page );
             }

         } ).start ();

        } else {
            //如果不为空，表示这是列表页,解析出详情页的url地址，放到任务队列中
            for (Selectable selectable : list) {
                //获取url地址
                String jobInfoUrl = selectable.links ().toString ();
                //把获取到的url地址放到任务队列中
                page.addTargetRequest ( jobInfoUrl );
            }

//            //获取下一页的url
//            String bkUrl = pageHtml.css("div.p_in li.bk").nodes().get(1).links().toString();
//            //把url放到任务队列中
//            page.addTargetRequest(bkUrl);


            //获取下一页的url
            Selectable selectable = pageHtml.css ( "div.item_con_pager" ).nodes ().get ( 1 );

            List<Selectable> nodes = selectable.css ( "a" ).nodes ();
            Selectable selectable1 = nodes.get ( nodes.size () - 1 );
            String string = selectable1.links ().toString ();


            System.out.println ("1234567890"+string);
            page.addTargetRequest ( string );

//            for (Selectable node:nodes
//                 ) {
//                String text = node.css ( "*","text" );
//                if (text == "下一页"){
//                    String url = node.links ().toString ();
//                    page.addTargetRequest(url);
//                }
//            }

            //把url放到任务队列中
//            page.addTargetRequest(bkUrl);

        }


        String html = pageHtml.toString ();


    }

    //解析页面，获取招聘详情信息，保存数据
    private void saveJobInfo(Page page) {
        //创建招聘详情对象
        JobInfo jobInfo = new JobInfo ();

        //解析页面
        Html html = page.getHtml ();

        String companyName = html.css ( "div.position-content-l h4.company", "text" ).toString ();
        if (companyName == null || companyName.length () == 0) {
            return;
        }
        String companyAddr = html.css ( "li.similar_list_item p.similar_company_name", "title" ).toString ();


        //获取数据，封装到对象中
        jobInfo.setCompanyName ( companyName );
        jobInfo.setCompanyAddr ( companyAddr );
        jobInfo.setUrl ( UUID.randomUUID ().toString () );
//        jobInfo.setCompanyInfo(Jsoup.parse(html.css("div.tmsg").toString()).text());
//        jobInfo.setJobName(html.css("div.cn h1","text").toString());
//        jobInfo.setJobAddr(html.css("div.cn span.lname","text").toString());
//        jobInfo.setJobInfo(Jsoup.parse(html.css("div.job_msg").toString()).text());
//        jobInfo.setUrl(page.getUrl().toString());
//
//        //获取薪资
//        Integer[] salary = MathSalary.getSalary(html.css("div.cn strong", "text").toString());
//        jobInfo.setSalaryMin(salary[0]);
//        jobInfo.setSalaryMax(salary[1]);
//
//        //获取发布时间
//        String time = Jsoup.parse(html.css("div.t1 span").regex(".*发布").toString()).text();
//        jobInfo.setTime(time.substring(0,time.length()-2));

        //把结果保存起来
        page.putField ( "jobInfo", jobInfo );
        System.out.println ( "保存了------------------------" );
    }


    private Site site = Site.me ()
            .setCharset ( "utf8" )//设置编码   utf8  gbk
            .setTimeOut ( 20 * 1000 )//设置超时时间
            .setRetrySleepTime ( 30 * 000 )//设置重试的间隔时间
            .setRetryTimes ( 3 );//设置重试的次数

    @Override
    public Site getSite() {
        return site;
    }

    @Autowired
    private SpringDataPipeline springDataPipeline;

    //initialDelay当任务启动后，等等多久执行方法
    //fixedDelay每个多久执行方法
    @Scheduled(initialDelay = 1000*1000, fixedDelay = 100 * 1000)
    public void process() {
        Spider.create ( new JobProcessor () )
                .addUrl ( url )
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100)))
                .thread ( 10 )
                .addPipeline ( this.springDataPipeline )
                .run ();
    }
}
