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
	
	@Value("MQ.exchange")
	private String exchange;
	
	@Value("messagesender.routingkey")
	private String routingkey;	
	
	public void send(Employee employee) {
		rabbitTemplate.convertAndSend(exchange, routingkey, employee);
		log.debug("Send msg = " + employee);
	    
	}
}
