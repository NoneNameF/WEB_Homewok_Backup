package com.service;

import com.dao.impl.UserDaoImpl;
import com.domain.User;

import java.util.List;

public interface UserService {
    //查询所有用户信息
    public List<User> findAll();
    //添加一个用户
    public boolean addUser(User user);
    //查找某一个用户
    public User findUser(int ID);
    //查找某一个用户
    public List<User> findUser(String Name);
    //删除某一个用户
    public boolean deleteUser(int ID);
    //更改某个用户信息
    public boolean changeUser(User user);
    //构造类
    public User creatUser(String name,int state,int layer,int room,double money);
    public User creatUser(int id,String name,int state,int layer,int room,double money);
    //修改用户金额
    public boolean depositMoney(int id,double money);
}
