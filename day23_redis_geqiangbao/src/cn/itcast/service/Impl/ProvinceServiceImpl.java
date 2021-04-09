package cn.itcast.service.Impl;

import cn.itcast.dao.Impl.ProvinceDaoImpl;
import cn.itcast.domain.Province;
import cn.itcast.jedis.util.JedisPoolUtil;
import cn.itcast.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDaoImpl provinceDao = new ProvinceDaoImpl ();

    @Override
    public List<Province> findAll() {
        List<Province> list = provinceDao.findAll ();
        return null;
    }

    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtil.getJedis ();
        String province_json = jedis.get ( "province" );
        if (province_json == null || province_json.length () == 0){
            System.out.println ("从数据库加载数据");
            List<Province> list = provinceDao.findAll ();
            ObjectMapper mapper = new ObjectMapper ();
            try {
                province_json = mapper.writeValueAsString ( list );
            } catch (JsonProcessingException e) {
                e.printStackTrace ();
            }
            jedis.set ( "province",province_json );
            jedis.close ();
        }
        return province_json;
    }
}
