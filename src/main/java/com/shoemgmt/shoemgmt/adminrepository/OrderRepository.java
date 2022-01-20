package com.shoemgmt.shoemgmt.adminrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoemgmt.shoemgmt.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
	//List<Order> findByDate(Date date);
	
	@Query(value = "select od.id,od.sid,od.uid, od.date from shoemgmt.order od  left join shoemgmt.shoe s on od.sid = s.sid where s.category=:category", nativeQuery = true)
	List<Order> findByCategory(String category);

	
	
}
