package com.logic;

import com.utils.DruidUtils;
import com.information.Manager;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ManagerService {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    String s;

    public Manager Login(Manager manager) {
        s = "select * from testdb.manager where Name=? and Password=?";
        List<Manager> list = jdbcTemplate.query(
                s,
                new BeanPropertyRowMapper<Manager>(Manager.class),
                manager.getName(),
                manager.getPassword());
        if (list.isEmpty() == false) return list.get(0);
        else return null;
    }
}
