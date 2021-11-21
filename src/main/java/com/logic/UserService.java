package com.logic;

import com.information.Manager;
import com.information.User;
import com.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserService {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(DruidUtils.getDataSource());
    private String s;

    public List<User> findAll(){
        s="select * from testdb.user";
        List<User> list = jdbcTemplate.query(s, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
    public boolean addUser(User user){
        s="insert into testdb.user values(null,?,?,?,?)";
        jdbcTemplate.update(s,user.getName(),user.getSex(),user.getAge(), 0);
        return true;
    }
    public boolean deleteUser(int ID){
        s="delete from testdb.user where ID=?";
        jdbcTemplate.update(s,ID);
        return true;
    }
    public User findUser(int ID){
        s="select * from testdb.user where ID=?";
        List<User> list = jdbcTemplate.query(s, new BeanPropertyRowMapper<User>(User.class),ID);
        return list.get(0);
    }
    public boolean changeUser(User user){
        deleteUser(user.getID());
        s="insert into testdb.user values(?,?,?,?,?)";
        jdbcTemplate.update(s,user.getID(),user.getName(),user.getSex(), user.getAge(),user.getMoney());
        return true;
    }
    public boolean depositMoney(User user){
        s="update testdb.user set money=? where ID=?";
        jdbcTemplate.update(s,user.getMoney(),user.getID());
        return true;
    }

}
