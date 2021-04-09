package com.xiaobao.dao;

import com.xiaobao.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao2 {
    /**
     * 查询操作
     * @return
     */
    List<User> finall();

    /**
     * 查询操作(注解)
     * @return
     */
    @Select( "select * from user" )
    List<User> finallAnnotation();

}
