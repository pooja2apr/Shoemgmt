package com.shoemgmt.shoemgmt.adminrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.shoemgmt.shoemgmt.model.ShoeAdmin;

@Repository
public interface AdminRepository extends JpaRepository<ShoeAdmin,Long> {
	List<ShoeAdmin> findByEmail(String email);

}
