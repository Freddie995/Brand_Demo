package com.gdufs.service;

import com.gdufs.mapper.UserMapper;
import com.gdufs.pojo.User;
import com.gdufs.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/29
 */


public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public boolean login(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.select(user.getUsername(), user.getPassword());
        sqlSession.close();
        if (u.getUsername()==null){
            return false;
        }else{
            return true;
        }
    }
    public boolean checkUser(String username){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.selectByUsername(username);
        if (u==null){
            return false;
        }else{
            return true;
        }

    }
    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(user);
        if (user.getUsername() != null && user.getPassword()!= null){
            mapper.add(user);
            sqlSession.commit();
            sqlSession.close();
            return true;
        }else {
            sqlSession.close();
            return false;
        }





    }
}
