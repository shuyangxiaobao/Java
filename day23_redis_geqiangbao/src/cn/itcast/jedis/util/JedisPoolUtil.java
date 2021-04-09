package cn.itcast.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class JedisPoolUtil {
    private static  JedisPool jedisPool;
    static {
        InputStream stream = JedisPoolUtil.class.getClassLoader ().getResourceAsStream ( "jedis.properties" );
        Properties properties = new Properties ();
        try {
            properties.load ( stream );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        String maxTotal = properties.getProperty ( "maxTotal" );
        String maxIdle = properties.getProperty ( "maxIdle" );
        String localhost = properties.getProperty ( "host" );
        String port = properties.getProperty ( "port" );

        JedisPoolConfig config = new JedisPoolConfig ();
        config.setMaxTotal ( Integer.parseInt ( maxTotal ) );
        config.setMaxIdle ( Integer.parseInt ( maxIdle ) );
        JedisPool pool = new JedisPool ( config, localhost, Integer.parseInt ( port ) );
        jedisPool = pool;
    }

    public  static  Jedis getJedis(){
        Jedis jedis = jedisPool.getResource ();
        return jedis;
    }


}
