package com.ex.web.controllers;

import com.ex.web.models.Users;
import com.ex.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/users")
public class LoginCtrl {
	private UserService userService;
	
    @Autowired
    public LoginCtrl(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public ResponseEntity<Boolean> validateUsr(@RequestParam("username")String username, @RequestParam("password")String password) {
        String msg = "";
        Users user = userService.login(username, password);
        if(user == null) {
        	 return new ResponseEntity<>(new Boolean(false), HttpStatus.BAD_REQUEST);
        } else {
        	return new ResponseEntity<>(new Boolean(true), HttpStatus.OK);
        }        
    }
}
