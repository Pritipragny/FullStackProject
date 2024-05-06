package com.kodnest.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.kodnest.project.entity.Song;
//import org.springframework.web.bind.annotation.ResponseBody;
import com.kodnest.project.entity.User;
import com.kodnest.project.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
private UserService userService;
	@PostMapping("/register")

	
	public String userRegistration(@ModelAttribute User user) {
		User existingUser=userService.emailExists(user);
//		 String email = user.getEmail();//email from user-form
//		 userService.emailExists(user);
		 
		 
		 if(existingUser==null) {
			 userService.addUser(user);
			 System.out.println("Usr added successfully");
			 System.out.println(user);
		 }
		 else {
			 System.out.println("Duplicate user");
			 
		 }
		return "home";
	}
		@PostMapping("/validate") 
		 public String validate(@RequestParam("email") String email, 
		   @RequestParam("password") String password, HttpSession session) {

		  if(userService.validUser(email, password)==true) {
		   
		   session.setAttribute("email", email);

		   String role = userService.getRole(email);

		   if(role != null && role.equals("admin")) {
		    return"adminhome";
		   }else{
		    return "cutomerhome";
		   }

		  }
		  else {
		   return "login";
		  }

	}
	        }
	
	        
	 


