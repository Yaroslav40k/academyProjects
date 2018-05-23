package com.andersen.MDB;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

import com.andersen.DTO.OrderDTO;

@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount > 1000") })
@JMSConnectionFactoryDefinition(name = "jms/javaee7/ConnectionFactory", className = "javax.jms.ConnectionFactory")
@JMSDestinationDefinition(name = "jms/javaee7/Topic", className = "javax.jms.Topic", interfaceName = "javax.jms.Topic")
public class ExpensiveOrderMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			OrderDTO order = message.getBody(OrderDTO.class);
			System.out.println("Большой заказ получен: " + order.toString());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
