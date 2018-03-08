package com.miniworkshop.springmvc.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniworkshop.springmvc.dao.MiniatureDAO;
import com.miniworkshop.springmvc.dao.OrderDAO;
import com.miniworkshop.springmvc.model.Order;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO dao;

	@Override
	public Order findOrderById(int orderId) {
		
		return dao.findOrderById(orderId);
	}

	@Override
	public void saveOrder(Order order) {
		dao.saveOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		dao.updateOrder(order);
		
	}

	@Override
	public void deleteOrderById(int orderId) {
		dao.deleteOrderById(orderId);
		
	}

	@Override
	public List<Order> findAllOrders() {
		
		return dao.findAllOrders();
	}

	@Override
	public List<Order> findOrdersByCustomer(int customerId) {
		
		return dao.findOrdersByCustomer(customerId);
	}

	@Override
	public List<Order> findAllOrdersByStatus(String status) {
		
		return dao.findAllOrdersByStatus(status);
	}

	@Override
	public List<Order> findAllOrdersFinishedByDate(Timestamp timestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findCurrentOrder(int customerID) {
		
		return dao.findCurrentOrder(customerID);
	}

}
