package com.shoemgmt.shoemgmt.AdminService;

import java.util.List;


import com.shoemgmt.shoemgmt.model.Users;



public interface UserService {
	List < Users > getAllUsers();
	void saveUsers(Users user);
	Users getUsersByUid(long uid);
	void deleteUsersByUid(long uid);

}
