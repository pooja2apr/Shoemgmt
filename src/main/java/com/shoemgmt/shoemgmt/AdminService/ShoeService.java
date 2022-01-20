package com.shoemgmt.shoemgmt.AdminService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoemgmt.shoemgmt.model.Shoe;

public interface ShoeService {
	List < Shoe > getAllShoe();
	void saveShoe(Shoe shoe);
	Shoe getShoeBySid(long sid);
	void deleteShoeBySid(long sid);	
	

}
