package com.xiaobao.dao;

import com.xiaobao.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
