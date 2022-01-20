package com.shoemgmt.shoemgmt.AdminService;

import java.util.List;


import com.shoemgmt.shoemgmt.model.ShoeAdmin;

public interface AdminService {
	void saveShoeAdmin(ShoeAdmin admin);
	List<ShoeAdmin> getShoeAdminByEmail(String email);
   ShoeAdmin getShoeAdminById(long id);
	

}
