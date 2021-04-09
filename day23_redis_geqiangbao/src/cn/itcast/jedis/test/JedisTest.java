package cn.itcast.jedis.test;

import cn.itcast.jedis.util.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        System.out.println ("main");
    }

    @Test
    public void test1() {
        System.out.println ( "11" );
        Jedis jedis = new Jedis ( "localhost", 6379 );
        jedis.set ( "name", "xiaobao" );
        System.out.println ( jedis.get ( "name" ) );
        jedis.set ( "age", "30" );
//        jedis.del ("name");
        jedis.set ( "male", "男" );

        Set<String> keys = jedis.keys ( "*" );
        System.out.println ( keys );

        for (String key : keys) {
            String value = jedis.get ( key );
            System.out.println ( "遍历😄：" + key + ":" + value );
        }

        jedis.setex ( "school", 20, "梧州学院" );


        System.out.println ( jedis.get ( "school" ) );
        jedis.close ();
    }


    @Test
    public void test3(){
        Jedis jedis = new Jedis ();
        jedis.hset ( "myset","username","xiaobao" );
        jedis.hset ( "myset","password","123456" );

        String name = jedis.hget ( "myset", "username" );
        String password = jedis.hget ( "myset", "password" );
        System.out.println (name+":"+password);

        Map<String, String> myset = jedis.hgetAll ( "myset" );
        xlp ( myset );

        jedis.hdel ( "myset","password" );
        xlp ( jedis.hgetAll ( "myset" ) );
        jedis.close ();


    }

    public static void xlp(Map<String,String> map){
        System.out.println ("");
        System.out.println ("<<<<<<<<<<<<<<<<<<<<<<<");
        Set<String> stringSet = map.keySet ();
        for (String key:stringSet
        ) {
            String value = map.get ( key );
            System.out.println (key+":"+value);
        }
        System.out.println (">>>>>>>>>>>>>>>>>>>>>>>");

    }


    @Test
    public void  test4(){
        Jedis jedis = new Jedis ();
        jedis.del ( "xlpList" );
        jedis.lpush ( "xlpList" ,"huxu","xiaolaopo","小老婆");
        jedis.rpush ( "xlpList","2","3","4" );
        List<String> list = jedis.lrange ( "xlpList", 0, -1 );
        xlp4 ( list );
        jedis.rpop ( "xlpList" );
        xlp4 ( jedis.lrange ( "xlpList", 0, -1 ) );
        jedis.close ();





    }

    static void xlp4(List<String> list){
        System.out.println ("");
        System.out.println ("<<<<<<<<<<<<<<<<<<<<<<<");
        for (String str:list
        ) {
            System.out.println (str);
        }
        System.out.println (">>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Test
    public void test5(){
        Jedis jedis = new Jedis ();
        jedis.sadd ( "xlpset" ,"xiao","bao","xue","xiao","24323");
        Set<String> xlpset = jedis.smembers ( "xlpset" );
        xlp5 ( xlpset );

        jedis.srem ( "xlpset","xiao" );
        xlp5 ( jedis.smembers ( "xlpset" ) );
        jedis.close ();


    }

    static void xlp5(Set<String> list){
        System.out.println ("");
        System.out.println ("<<<<<<<<<<<<<<<<<<<<<<<");
        for (String str:list
        ) {
            System.out.println (str);
        }
        System.out.println (">>>>>>>>>>>>>>>>>>>>>>>");
    }


    @Test
    public void test6(){
        Jedis jedis = new Jedis ();
        jedis.zadd ( "sortset",10,"xiaoming" );
        jedis.zadd ( "sortset",13,"xiaoming9" );
        for (int i = 0;i<10;i++){
            jedis.zadd ( "sortset",i+90,"xiaoming"+i );
        }
        Set<String> sortset = jedis.zrange ( "sortset", 0, -1 );
        xlp6 ( sortset );


        jedis.zrem ( "sortset","xiaoming8" );
        xlp6 ( jedis.zrange ( "sortset",0,-1 ) );
        jedis.close ();


    }


    static void xlp6(Set<String> set){
        System.out.println ("");
        System.out.println ("<<<<<<<<<<<<<<<<<<<<<<<");
        for (String str:set
        ) {
            System.out.println (str);
        }
        System.out.println (">>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Test
    public void test7(){
        JedisPoolConfig config = new JedisPoolConfig ();
        config.setMaxTotal ( 50 );
        config.setMaxIdle ( 10 );

        JedisPool jedisPool = new JedisPool ( config, "localhost", 6379 );
        Jedis jedis = jedisPool.getResource ();
        jedis.set ( "name","hubaobao" );
        System.out.println (jedis.get ( "name" ));

        jedis.close ();
    }


    @Test
    public void test8(){
//        Jedis jedis = JedisPoolUtil.getJedis ();
        Jedis jedis = JedisPoolUtil.getJedis();


        jedis.set ( "name","xiaoming" );
        System.out.println (jedis.get ( "name" ));
        jedis.close ();

    }


}


