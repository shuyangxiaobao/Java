package com.xiaobao.dao;

import com.xiaobao.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /**
     * 查询操作
     * @return
     */
    List<User> finall();


    /**
     * 查询操作(注解)
     * @return
             */
        @Select ( "select * from user" )
    List<User> finallAnnotation();


    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);


    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

}
