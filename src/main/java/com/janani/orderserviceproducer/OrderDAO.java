package com.janani.orderserviceproducer;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {

	public void save(Order order) {
		System.out.println("Order placed successfully");
	}

}
