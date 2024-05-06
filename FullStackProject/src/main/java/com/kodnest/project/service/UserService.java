package com.kodnest.project.service;

import java.util.List;

//import com.kodnest.project.entity.Song;
import com.kodnest.project.entity.User;

public interface UserService {
	List<User> getUser();
	void addUser(User user);
	User emailExists(String email);
	User emailExists(User user);
	boolean isUserAdmin(String email);
	boolean isUserCustomer(String email);
//	void saveSong(Song song);
	void updateUser(User user);
	User getUser(String mail);
	
	String getRole(String email);
	boolean validUser(String email, String password);
	
}

