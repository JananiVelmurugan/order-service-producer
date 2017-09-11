package com.janani.orderserviceproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService publisher;

	@RequestMapping("/save")
	public String save(@RequestParam("msg") String msg) {
		Order order = new Order();
		order.setOrderId(2);
		order.setOrderName("Earrings");
		publisher.placeOrder(msg, order);
		return "Order Placed";
	}
}
