package com.janani.orderserviceproducer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private FanoutExchange fanoutExchange;

	@Autowired
	private OrderDAO orderDAO;
	
	public void placeOrder(String msg, Order order) {
		System.out.println("Order Details" + order);
		
		// 1. Save the order in the db
		orderDAO.save(order);
		
		// 2. Send the notification message
		rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", order);
		
		System.out.println("Place an order = " + msg);
	}
}