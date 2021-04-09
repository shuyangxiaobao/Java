package com.xiaobao.dao.Impl;

import com.xiaobao.dao.IgqbAccountDao;
import com.xiaobao.domain.GqbAccount;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("accountDao")
public class IgqbAccountDaoImpl implements IgqbAccountDao {

//    @Autowired
    @Resource(name = "runner")
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
    @Override
    public List<GqbAccount> findAllAccount() {
        try{
            return runner.query("select * from gqbAccount",new BeanListHandler<GqbAccount> (GqbAccount.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
