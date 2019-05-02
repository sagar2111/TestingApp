package com.unitTest.UnitTestDemo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.unitTest.UnitTestDemo.entity.Employee;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("")
	private String exchange;
	
	@Value("")
	private String routingkey;	
	
	public void send(Employee company) {
		rabbitTemplate.convertAndSend(exchange, routingkey, company);
		log.debug("Send msg = " + company);
	    
	}
}
