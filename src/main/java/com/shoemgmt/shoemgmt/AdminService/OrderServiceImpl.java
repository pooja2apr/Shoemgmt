package com.shoemgmt.shoemgmt.AdminService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoemgmt.shoemgmt.adminrepository.OrderRepository;
import com.shoemgmt.shoemgmt.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Long Long = null;
	@Autowired
	OrderRepository orderrepository;
	
	@Override
	public List<Order> getAllOrders(){
		return orderrepository.findAll();
		
	}
	
	@Override
	public void saveOrder(Order order) {
		this.orderrepository.save(order);
	}
	@Override
	public Order getOrderById(long id) {
		Order order=orderrepository.findById(id).get();
		return order;
	}
		
	@Override 
	public void deleteOrderById(long id) {
		this.orderrepository.deleteById(id);
	}
	


	@Override
	public List<Order> findByCategory(String category) {
		List< Order> oList = orderrepository.findByCategory(category);
		return oList;
	}

	@Override
	public List<Order> findByDate() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
