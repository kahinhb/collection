package com.hb.dao;

import com.hb.pojo.User;
import com.hb.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        //获取对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user =userDao.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.addUser(new User(4,"曹操","111111"));
        if(res>0){
            System.out.println("插入成功");
        }
        //提交事务 ---必须
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.updateUser(new User(4,"刘备","111111"));
        if(res>0){
            System.out.println("更新成功");
        }
        //提交事务 ---必须
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.deleteUser(4);
        if(res>0){
            System.out.println("删除成功");
        }
        //提交事务 ---必须
        sqlSession.commit();
        sqlSession.close();
    }
}
