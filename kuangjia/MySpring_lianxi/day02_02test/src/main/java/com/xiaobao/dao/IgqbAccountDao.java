package com.xiaobao.dao;

import com.xiaobao.domain.GqbAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gqbAccountDao")
public interface IgqbAccountDao {
    public List<GqbAccount> findAllAccount();
}
