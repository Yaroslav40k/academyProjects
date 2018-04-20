package com.miniworkshop.springmvc.dao;

import java.util.List;

import com.miniworkshop.springmvc.model.OrderDetails;
import com.miniworkshop.springmvc.model.User;

public interface OrderDeatilsDAO {

	OrderDetails findOrderDeatilsById(int orderDeatilsId);

	void saveOrderDetails(OrderDetails orderDeatils);

	void updateOrderDetails(OrderDetails orderDeatils);

	void deleteOrderDetailsById(int orderDeatilsId);

	List<OrderDetails> findAllOrderDetails();

	List<OrderDetails> findAllOrderDetailsByOrder(int orderId);
	
	List<OrderDetails> findAllOrderDetailsByCustomer(User userCustomer);

}
