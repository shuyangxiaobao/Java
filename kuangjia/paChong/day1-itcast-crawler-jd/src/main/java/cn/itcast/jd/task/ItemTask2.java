package cn.itcast.jd.task;

import cn.itcast.jd.pojo.Item;
import cn.itcast.jd.service.ItemService;
import cn.itcast.jd.util.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ItemTask2 {

    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private ItemService itemService;

    private static final ObjectMapper MAPPER = new ObjectMapper ();


    //当下载任务完成后，间隔多长时间进行下一次的任务。
    @Scheduled(fixedDelay = 10 * 1000)
    public void itemTask() throws Exception {
        //声明需要解析的初始地址
        String url = "https://search.jd.com/Search?keyword=%E9%9E%8B%E5%AD%90&wq=%E9%9E%8B%E5%AD%90&s=101&click=0&page=";

        String title = "女神短裙";
        url = "https://search.jd.com/Search?keyword=" +
                title +
                "&suggest=4.def.0.base&wq=" +
                title +
                "&s=101&click=0&page=";




        for(int i = 0;i<10;i++){
            url = url+ i;
            String html = httpUtils.doGetHtml ( url );

            //解析页面，获取商品数据并存储
            this.parse ( html );
        }



        System.out.println ( "手机数据抓取完成！" );




    }

    //解析页面，获取商品数据并存储
    private void parse(String html) throws Exception {
        //解析html获取Document
        Document doc = Jsoup.parse ( html );

        //获取spu信息
        Elements list = doc.select ( "div#J_goodsList > ul > li" );

        for (Element spuEle : list) {
            String attr = spuEle.select ( "img" ).attr ( "src" );
            attr = "https:" + attr;
            this.httpUtils.doGetImage ( attr );

            Item item = new Item ();
            item.setUrl ( attr );

            //                //保存商品数据到数据库中
            this.itemService.save ( item );
        }
    }

}
