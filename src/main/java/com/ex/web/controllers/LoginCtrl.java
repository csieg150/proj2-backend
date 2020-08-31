package com.ex.web.controllers;

import com.ex.web.models.UserResponse;
import com.ex.web.models.Users;
import com.ex.web.services.UserService;
import com.ex.web.templates.LoginTemplate;
import com.ex.web.templates.SignupTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class LoginCtrl {
	private UserService userService;
	
    @Autowired
    public LoginCtrl(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping
    public ResponseEntity<UserResponse> validateUsr(@RequestBody LoginTemplate loginTemplate) {
        Users user = userService.login(loginTemplate.getUsername(), loginTemplate.getPassword());
        if(user == null) {
        	 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
        	return new ResponseEntity<>(new UserResponse(user.getFirst_Name(), user.getLast_Name()), HttpStatus.OK);
        }        
    }
    
    @PutMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody SignupTemplate signupTemplate){
    	Users user = userService.createAccount(signupTemplate);
    	if(user == null) {
       	 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       } else {
       	return new ResponseEntity<>(new UserResponse(user.getFirst_Name(), user.getLast_Name()), HttpStatus.CREATED);
       }
    }
    
}
