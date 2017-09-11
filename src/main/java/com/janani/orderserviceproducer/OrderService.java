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

	public void placeOrder(String msg, Order order) {
		rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", order);
		System.out.println("Place an order = " + msg);
		System.out.println("Order Details" + order);
	}
}