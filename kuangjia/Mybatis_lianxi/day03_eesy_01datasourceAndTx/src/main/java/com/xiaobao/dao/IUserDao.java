package com.xiaobao.dao;

import com.xiaobao.domain.QueryVo;
import com.xiaobao.domain.User;

import java.util.List;

public interface IUserDao {


    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();


    List<User> findUserByVo(QueryVo vo);

    List<User> findUserByCondition(User user);

    List<User> findUserInIds(QueryVo vo);


}
