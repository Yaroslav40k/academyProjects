package com.miniworkshop.springmvc.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.miniworkshop.springmvc.model.Miniature;
import com.miniworkshop.springmvc.model.Order;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDao<Integer, Order> implements OrderDAO {

	@Override
	public Order findOrderById(int orderId) {
		Order order = getByKey(orderId);
		return order;
	}

	@Override
	public void saveOrder(Order order) {
		persist(order);
		
	}

	@Override
	public void updateOrder(Order order) {
		update(order);
		
	}

	@Override
	public void deleteOrderById(int orderId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("orderId", orderId));
		Order order = (Order) crit.uniqueResult();
		delete(order);
		
	}

	@Override
	public List<Order> findAllOrders() {
		
		Criteria criteria = createEntityCriteria().addOrder(org.hibernate.criterion.Order.asc("order_id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
		List<Order> orders = (List<Order>) criteria.list();
		return orders;
	}

	@Override
	public List<Order> findOrdersByCustomer(int customerId) {
		Criteria criteria = createEntityCriteria().addOrder(org.hibernate.criterion.Order.asc("order_id"));
		criteria.add(Restrictions.eq("customerId", customerId));
		List<Order> orders = (List<Order>) criteria.list();
		return orders;
	}

	@Override
	public List<Order> findAllOrdersByStatus(String status) {
		Criteria criteria = createEntityCriteria().addOrder(org.hibernate.criterion.Order.asc("order_id"));
		criteria.add(Restrictions.eq("orderStatus", status));
		List<Order> orders = (List<Order>) criteria.list();
		return orders;
	}

	@Override
	public List<Order> findAllOrdersFinishedByDate(Timestamp timestamp) {
		Criteria criteria = createEntityCriteria().addOrder(org.hibernate.criterion.Order.asc("order_id"));
		criteria.add(Restrictions.eq("finishedDate", timestamp));
		List<Order> orders = (List<Order>) criteria.list();
		return orders;
	}

}
