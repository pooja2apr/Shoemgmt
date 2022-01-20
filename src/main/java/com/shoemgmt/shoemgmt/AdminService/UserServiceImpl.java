package com.shoemgmt.shoemgmt.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoemgmt.shoemgmt.adminrepository.UserRepository;


import com.shoemgmt.shoemgmt.model.Users;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;


	@Override
	public List <Users> getAllUsers() {

		return userRepository.findAll();

	}

	@Override
	public void saveUsers(Users user) {
		this.userRepository.save(user);
	}
	 @Override
	    public Users getUsersByUid(long uid) {
	        Users user =userRepository.findById(uid).get();
	        return user;
	    }
	@Override
	public void deleteUsersByUid(long uid) {
		this.userRepository.deleteById(uid);
	}


}
