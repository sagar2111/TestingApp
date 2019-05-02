package com.unitTest.UnitTestDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.service.RabbitMQSender;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "RabitMQ Management System", description = "Send a message in MQ")
@RestController
public class RabbitMQWebController {
	
	@Autowired
	RabbitMQSender rabbitMQSender;

	@ApiOperation(value = "Get an employee")
	@GetMapping(value = "/producer")
	public String producer(
			@ApiParam(value = "Employee info from which employee object will retrieve", required = true) @RequestParam("id") Long empid,
			@RequestParam("name") String empName, @RequestParam("department") String empDepartment,
			@RequestParam("salary") int empSalary) {

		Employee emp = new Employee();
		emp.setId(empid);
		emp.setName(empName);
		emp.setDepartment(empDepartment);
		emp.setSalary(empSalary);
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ  Successfully";
	}

}
