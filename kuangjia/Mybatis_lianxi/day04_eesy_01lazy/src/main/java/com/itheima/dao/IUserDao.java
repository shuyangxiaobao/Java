package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {

   public  List<User> findAll ();

   public User findByUserID ();
}
