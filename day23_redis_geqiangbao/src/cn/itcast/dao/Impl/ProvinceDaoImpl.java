package cn.itcast.dao.Impl;

import cn.itcast.dao.ProvincDao;
import cn.itcast.domain.Province;
import cn.itcast.util.JDBCUtils;
import com.alibaba.druid.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvincDao {


//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private  JdbcTemplate template = new JdbcTemplate ( JDBCUtils.getDataSource () );

    @Override
    public List<Province> findAll() {
        String sql = "select *from province";
        List<Province> list = template.query ( sql, new BeanPropertyRowMapper<> ( Province.class ) );
        return list;
    }
}
