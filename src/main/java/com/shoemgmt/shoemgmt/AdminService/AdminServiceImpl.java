package com.shoemgmt.shoemgmt.AdminService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoemgmt.shoemgmt.adminrepository.AdminRepository;
import com.shoemgmt.shoemgmt.model.ShoeAdmin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminrepository;

	@Override
	public void saveShoeAdmin(ShoeAdmin admin) {
		this.adminrepository.save(admin);


	}

	@Override
	public List<ShoeAdmin> getShoeAdminByEmail(String email) {
		List< ShoeAdmin> aList = adminrepository.findByEmail(email);
		return aList;    
	}
	
	@Override
    public ShoeAdmin getShoeAdminById(long id) {
        Optional < ShoeAdmin > optional = adminrepository.findById(id);
        ShoeAdmin admin = null;
        if (optional.isPresent()) {
            admin = optional.get();
        } else {
            throw new RuntimeException(" admin not found for id :: " + id);
        }
        return admin;
    }
}


