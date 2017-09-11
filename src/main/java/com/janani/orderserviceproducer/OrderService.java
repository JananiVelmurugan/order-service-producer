package com.janani.orderserviceproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private FanoutExchange fanoutExchange;

	public void placeOrder(String msg) {
		amqpTemplate.convertAndSend(fanoutExchange.getName(), "", msg);
		System.out.println("Place an order = " + msg);
	}
}