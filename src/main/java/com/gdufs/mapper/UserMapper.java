package com.gdufs.mapper;

import com.gdufs.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/27
 */


public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    //根据用户名查询用户对象
    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);
    //添加用户
    @Insert("insert into user values(null,#{username},#{password})")
    void add(User user);
}
