package com.miniworkshop.springmvc.service;

import java.sql.Timestamp;
import java.util.List;

import com.miniworkshop.springmvc.model.Order;

public interface OrderService {
	
	Order findOrderById(int orderId);
	
	Order findCurrentOrder(int customerID);

	void saveOrder(Order order);

	void updateOrder(Order order);

	void deleteOrderById(int orderId);

	List<Order> findAllOrders();

	List<Order> findOrdersByCustomer(int customerId);

	List<Order> findAllOrdersByStatus(String status);
	
	List<Order> findAllOrdersFinishedByDate(Timestamp timestamp);

}
