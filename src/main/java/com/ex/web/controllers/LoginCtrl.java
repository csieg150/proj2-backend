package com.ex.web.controllers;

import com.ex.web.models.Users;
import com.ex.web.services.UserService;
import com.ex.web.templates.LoginTemplate;
import com.ex.web.templates.SignupTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping
    public ResponseEntity<String> validateUsr(@RequestBody LoginTemplate loginTemplate) {
        Users user = userService.login(loginTemplate.getUsername(), loginTemplate.getPassword());
        if(user == null) {
        	 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
        	String name = user.getFirst_Name() + user.getLast_Name();
        	return new ResponseEntity<>(name, HttpStatus.OK);
        }        
    }
    
    @PutMapping
    public ResponseEntity<String> createUser(@RequestBody SignupTemplate signupTemplate){
    	Users user = userService.createAccount(signupTemplate);
    	if(user == null) {
       	 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       } else {
       	String name = user.getFirst_Name() + user.getLast_Name();
       	return new ResponseEntity<>(name, HttpStatus.CREATED);
       }
    }
    
}
