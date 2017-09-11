package com.janani.orderserviceproducer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfiguration {
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;

	@Bean
	public FanoutExchange exchange() {
		return new FanoutExchange(exchange);
	}
}
