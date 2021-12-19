package com.dao;

import com.domain.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public boolean addUser(User user);

    public User findUser(int ID);

    public boolean deleteUser(int ID);

}
