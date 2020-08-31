package com.ex.web;

import com.ex.web.models.Albums;
import com.ex.web.services.AlbumService;
import com.ex.web.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {
    UserService userService;

    @Autowired
    public Main(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        Main m = ac.getBean("main", Main.class);
        boolean foo =  m.userService.deleteUser(m.userService.getUserIdByUsername("NavPan"));
        System.out.println("Deleted: " + foo);
        ac.close();
    }
}
