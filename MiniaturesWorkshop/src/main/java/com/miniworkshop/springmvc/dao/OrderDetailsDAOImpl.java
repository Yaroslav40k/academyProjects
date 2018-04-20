package com.miniworkshop.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.miniworkshop.springmvc.model.Order;
import com.miniworkshop.springmvc.model.OrderDetails;
import com.miniworkshop.springmvc.model.User;

@Repository("orderDetailsDAO")
public class OrderDetailsDAOImpl extends AbstractDao<Integer, OrderDetails> implements OrderDeatilsDAO {

	@Override
	public OrderDetails findOrderDeatilsById(int orderDeatilsId) {
		OrderDetails orderDeatils = getByKey(orderDeatilsId);
		return orderDeatils;
	}

	@Override
	public void saveOrderDetails(OrderDetails orderDeatils) {
		persist(orderDeatils);
		
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDeatils) {
		update(orderDeatils);
		
	}

	@Override
	public void deleteOrderDetailsById(int orderDeatilsId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("order_detail_id", orderDeatilsId));
		OrderDetails orderDeatils = (OrderDetails) crit.uniqueResult();
		delete(orderDeatils);
		
	}

	@Override
	public List<OrderDetails> findAllOrderDetails() {
		Criteria criteria = createEntityCriteria().addOrder(org.hibernate.criterion.Order.asc("order_detail_id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
		List<OrderDetails> orderDeatils = (List<OrderDetails>) criteria.list();
		return orderDeatils;
	}


	@Override
	public List<OrderDetails> findAllOrderDetailsByOrder(int orderId) {
		Criteria criteria = createEntityCriteria().addOrder(org.hibernate.criterion.Order.asc("order_detail_id"));
		criteria.add(Restrictions.eq("orderId", orderId));
		List<OrderDetails> orderDeatils = (List<OrderDetails>) criteria.list();
		return orderDeatils;
	}

	@Override
	public List<OrderDetails> findAllOrderDetailsByCustomer(User userCustomer) {	
		Criteria criteriaDeatils = createEntityCriteria().addOrder(org.hibernate.criterion.Order.asc("order_detail_id"));
		criteriaDeatils.add(Restrictions.eq("userCustomer", userCustomer));
		List<OrderDetails> orderDeatils = (List<OrderDetails>) criteriaDeatils.list();
		return orderDeatils;
	}

}
