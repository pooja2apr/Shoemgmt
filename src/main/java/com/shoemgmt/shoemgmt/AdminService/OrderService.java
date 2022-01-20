package com.shoemgmt.shoemgmt.AdminService;

import java.util.Date;
import java.util.List;

import com.shoemgmt.shoemgmt.model.Order;

public interface OrderService {
	List < Order > getAllOrders();
	void saveOrder(Order order);
	Order getOrderById(long id);
	void deleteOrderById(long id);
	
	List<Order> findByCategory(String category);
	List<Order> findByDate();
}
