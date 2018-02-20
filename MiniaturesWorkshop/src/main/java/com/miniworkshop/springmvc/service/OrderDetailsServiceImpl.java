package com.miniworkshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniworkshop.springmvc.dao.OrderDeatilsDAO;
import com.miniworkshop.springmvc.model.OrderDetails;

@Service("orderDetailsService")
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	OrderDeatilsDAO dao;

	@Override
	public OrderDetails findOrderDeatilsById(int orderDeatilsId) {

		return dao.findOrderDeatilsById(orderDeatilsId);
	}

	@Override
	public void saveOrderDetails(OrderDetails orderDeatils) {
		dao.saveOrderDetails(orderDeatils);
		
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDeatils) {
	dao.updateOrderDetails(orderDeatils);
		
	}

	@Override
	public void deleteOrderDetailsById(int orderDeatilsId) {
		dao.deleteOrderDetailsById(orderDeatilsId);
		
	}

	@Override
	public List<OrderDetails> findAllOrderDetails() {
		
		return dao.findAllOrderDetails();
	}

	@Override
	public List<OrderDetails> findAllOrderDetailsByChart(int chartId) {
		return dao.findAllOrderDetailsByChart(chartId);
	}

	@Override
	public List<OrderDetails> findAllOrderDetailsByOrder(int  orderId) {
		// TODO Auto-generated method stub
		return dao.findAllOrderDetailsByOrder(orderId);
	}
	
	
	

}
