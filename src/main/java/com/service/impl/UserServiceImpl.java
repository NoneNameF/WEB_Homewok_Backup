package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;
import com.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public List<User> findAll() {
        return userDao.findAll();
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public User findUser(int ID) {
        return userDao.findUser(ID);
    }
    public List<User> findUser(String Name) {
        return userDao.findUser(Name);
    }
    public boolean deleteUser(int ID) {
        return userDao.deleteUser(ID);
    }

    public boolean changeUser(User user) {
        deleteUser(user.getId());
        return addUser(user);
    }
    public User creatUser(String name, int state, int layer, int room,double money) {
        User user = new User();
        user.setName(name);
        user.setState(state);
        user.setLayer(layer);
        user.setRoom(room);
        user.setMoney(money);
        return user;
    }
    public User creatUser(int id, String name, int state, int layer, int room,double money) {
        User user = creatUser(name, state, layer, room,money);
        user.setId(id);
        return user;
    }

    public boolean depositMoney(int id,double money){
        User user1 = userDao.findUser(id);
        user1.setMoney(money);
        return changeUser(user1);
    }
}
