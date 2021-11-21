package com.test;

import com.information.Manager;
import com.logic.ManagerService;
import org.junit.jupiter.api.Test;

public class ManagerServiceTest {
    @Test
    public void testLogin(){
        Manager manager=new Manager();
        manager.setName("root");
        manager.setPassword("root");
        ManagerService managerService =new ManagerService();
        System.out.println(managerService.Login(manager));
    }
    @Test
    public void test(){

    }
}
