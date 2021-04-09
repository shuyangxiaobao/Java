package com.xiaobao.service.Impl;

import com.xiaobao.dao.IgqbAccountDao;
import com.xiaobao.domain.GqbAccount;
import com.xiaobao.service.IGqbAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService2")
public class GqbAccountServiceImpl implements IGqbAccountService {

    @Resource(name = "accountDao")
    private IgqbAccountDao accountDao;

    public void setAccountDao(IgqbAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<GqbAccount> findAllAccount() {
        return accountDao.findAllAccount ();
    }
}
