package com.xiaobao.dao;

import com.xiaobao.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();


    /**
     * 保存用户信息
     * @param user
     */
    void saveuser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteUser(int id);


    /**
     * 根据id查询用户
     * @param id
     */
    User findByid(int id);





}
