package com.shoemgmt.shoemgmt.adminrepository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoemgmt.shoemgmt.model.Shoe;
@Repository
public interface ShoeRepository extends JpaRepository<Shoe,Long> {
	

}
