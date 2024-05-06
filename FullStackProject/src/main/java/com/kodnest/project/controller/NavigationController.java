package com.kodnest.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	@GetMapping("/registration")
	public String registration() {
		return "registration";
		
	}
	@GetMapping("/adminhome")
    public String adminhome() {
        return "adminhome";
    }
 @GetMapping("customerhome")
    public String customerhome() {
        return "customerhome";
    }
 @GetMapping("/addsongs")
 public String song() {
     return "song";
 }
 
	

}
