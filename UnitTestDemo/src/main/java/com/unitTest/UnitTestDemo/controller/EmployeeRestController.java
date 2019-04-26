package com.unitTest.UnitTestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JavaSolutionsGuide
 *
 */
@RestController
@Slf4j
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	

	@GetMapping("/api/employees/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping("/api/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		log.debug("Employee Saved Successfully");
		return employee.getName();
	}

	@DeleteMapping("/api/employees/{employeeId}")
	public int deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
		
	}

}
