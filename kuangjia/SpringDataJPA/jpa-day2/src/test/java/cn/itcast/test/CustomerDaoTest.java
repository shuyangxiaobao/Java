package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(4l);
        System.out.println("🍺🍺🍺🍺"+customer);
    }


    @Test
    public void demo1(){
        System.out.println ("34567890-=");
        Customer one = customerDao.findOne ( 2l );
        System.out.println (one);
    }
    @Test
    public void demo2(){
        Customer customer = new Customer ();
        customer.setCustName ( "woshi" );
        customer.setCustAddress ( "北京" );
        customer.setCustIndustry ( "上海" );
        customer.setCustLevel ( "level" );
        customer.setCustId ( 6l ); // 带主键ID 就是更新
        customerDao.save ( customer );
    }



    /**
     * save : 保存或者更新
     *      根据传递的对象是否存在主键id，
     *      如果没有id主键属性：保存
     *      存在id主键属性，根据id查询数据，更新数据
     */
    @Test
    public void testSave() {
        System.out.println ("q3rqwerwqerwqer");

        Customer customer  = new Customer();
        customer.setCustName("黑马程序员");
        customer.setCustLevel("vip");
        customer.setCustIndustry("it教育");
        customerDao.save(customer);
    }

    @Test
    public void testUpdate() {
        Customer customer  = new Customer();
        customer.setCustId(4l);
        customer.setCustName("黑马程序员很厉害");
        customerDao.save(customer);// 主键不为空，就更新，主键为空就保存
    }

    @Test
    public void testDelete () {
        customerDao.delete(3l);
    }


    @Test
    public void demo3(){
        Customer customer = new Customer ();
        customer.setCustName ( "woshi" );
        customer.setCustAddress ( "北京" );
        customer.setCustIndustry ( "上海" );
        customer.setCustLevel ( "level" );
        customer.setCustId ( 3l );
       customerDao.delete (customer );
    }




    @Test
    public void demo4(){
        List<Customer> list = customerDao.findAll ();
        for (Customer cu:list
             ) {
            System.out.println (cu);
        }

    }



    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<Customer> list = customerDao.findAll();
        for(Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 测试统计查询：查询客户的总数量
     *      count:统计总条数
     */
    @Test
    public void testCount() {
        long count = customerDao.count();//查询全部的客户数量
        System.out.println(count);
    }

    @Test
    public void demo5(){
        long count = customerDao.count ();
        System.out.println (count);

    }



    /**
     * 测试：判断id为4的客户是否存在
     *      1. 可以查询以下id为4的客户
     *          如果值为空，代表不存在，如果不为空，代表存在
     *      2. 判断数据库中id为4的客户的数量
     *          如果数量为0，代表不存在，如果大于0，代表存在
     */
    @Test
    public void  testExists() {
        boolean exists = customerDao.exists(4l);
        System.out.println("id为4的客户 是否存在："+exists);
    }

    @Test
    public void demo6(){
        boolean exists = customerDao.exists ( 9l );
        System.out.println (exists);
    }


    /**
     * 根据id从数据库查询
     *      @Transactional : 保证getOne正常运行
     *
     *  findOne：
     *      em.find()           :立即加载
     *  getOne：
     *      em.getReference     :延迟加载
     *      * 返回的是一个客户的动态代理对象
     *      * 什么时候用，什么时候查询
     */
    @Test
    @Transactional
    public void  testGetOne() {
        Customer customer = customerDao.getOne(4l);
        System.out.println(customer);
        System.out.println ("234234234");
    }


    @Test
    @Transactional
    public void demo7(){
        Customer one = customerDao.getOne ( 4l );
        System.out.println ("🍺🍺🍺🍺"+one);
    }


}
