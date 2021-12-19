package com.dao.impl;

import com.dao.ManagerDao;
import com.domain.Manager;
import com.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ManagerDaoImpl implements ManagerDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    String s;
    @Override
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
