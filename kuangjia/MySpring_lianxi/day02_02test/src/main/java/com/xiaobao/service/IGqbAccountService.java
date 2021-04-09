package com.xiaobao.service;

import com.xiaobao.dao.IgqbAccountDao;
import com.xiaobao.domain.GqbAccount;

import java.util.List;

public interface IGqbAccountService {
    public List<GqbAccount> findAllAccount();

}
