package com.miniworkshop.springmvc.service;

import java.util.List;

import com.miniworkshop.springmvc.model.OrderDetails;

public interface OrderDetailsService {
	
	OrderDetails findOrderDeatilsById(int orderDeatilsId);

	void saveOrderDetails(OrderDetails orderDeatils);

	void updateOrderDetails(OrderDetails orderDeatils);

	void deleteOrderDetailsById(int orderDeatilsId);

	List<OrderDetails> findAllOrderDetails();

	List<OrderDetails> findAllOrderDetailsByChart(int chartId);

	List<OrderDetails> findAllOrderDetailsByOrder(int orderId);


}
