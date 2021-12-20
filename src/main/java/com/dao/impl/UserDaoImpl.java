package com.dao.impl;

import com.dao.UserDao;
import com.domain.User;
import com.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate=new JdbcTemplate(DruidUtils.getDataSource());
    private String s;

    public List<User> findAll(){
        s="select * from testdb.user";
        return jdbcTemplate.query(s, new BeanPropertyRowMapper<User>(User.class));
    }
    public boolean addUser(User user){
        s="insert into testdb.user values(?,?,?,?,?,?)";
        jdbcTemplate.update(s,user.getId(),user.getName(), user.getState(),user.getLayer(),user.getRoom(),user.getMoney());
        return true;
    }
    public User findUser(int ID){
        s="select * from testdb.user where ID=?";
        List<User> list = jdbcTemplate.query(s, new BeanPropertyRowMapper<User>(User.class),ID);
        return list.get(0);
    }
    public List<User> findUser(String Name){
        s="select * from testdb.user where name=?";
        return jdbcTemplate.query(s, new BeanPropertyRowMapper<User>(User.class),Name);
    }
    public boolean deleteUser(int ID){
        s="delete from testdb.user where ID=?";
        jdbcTemplate.update(s,ID);
        return true;
    }
}
