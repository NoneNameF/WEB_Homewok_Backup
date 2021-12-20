package com.service.impl;

import com.dao.ManagerDao;
import com.dao.impl.ManagerDaoImpl;
import com.domain.Manager;
import com.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    ManagerDao managerDao=new ManagerDaoImpl();
    @Override
    public Manager Login(Manager manager) {
        return managerDao.Login(manager);
    }
}
