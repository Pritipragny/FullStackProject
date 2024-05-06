package com.kodnest.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.kodnest.project.entity.Song;
import com.kodnest.project.entity.User;
import com.kodnest.project.repository.UserRepository;
import com.kodnest.project.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUser() {
	
		return userRepository.findAll();
	}

	 @Override
	    public void addUser(User user) {
	        userRepository.save(user);
	 }

	@Override
	public User emailExists(User user) {
		User existingUser=userRepository.findByEmail(user.getEmail());
  if( existingUser!=null) {
			System.out.println("Present");
			return existingUser;
		}
  else {
	  System.out.println("Absent");
	  return null;
  }			
	}
	@Override
    public boolean isUserAdmin(String email) {
        User user = userRepository.findByEmail(email);
        return user != null && "admin".equals(user.getRole());
    }
    @Override
    public boolean isUserCustomer(String email) {
        User user = userRepository.findByEmail(email);
        return user != null && "customer".equals(user.getRole());
    }
    @Override
    public User emailExists(String email) {
        return userRepository.findByEmail(email);
    }
//	@Override
//	public void saveSong(Song song) {
//		userRepository.save(song);	
//	}

	@Override
	public void updateUser(User user) {
		 userRepository.save(user);
		
		
	}

	@Override
	public User getUser(String mail) {
		
		  return userRepository.findByEmail(mail);
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		  String dbpwd = user.getPassword();

		  if(password.equals(dbpwd)) {
		   return true;
		  }else {
		
		return false;
	}
	}  
}

