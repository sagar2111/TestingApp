package com.unitTest.UnitTestDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitTest.UnitTestDemo.DTO.Response;
import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * @author JavaSolutionsGuide
 *
 */
@RestController
@Slf4j
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@ApiOperation(value = "Get an employee by Id")
	@GetMapping("/api/employees/{employeeId}")
	public Response getEmployeeResponse(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.getEmployeeResponse(employeeId);
	}

	@ApiOperation(value = "Get an employee by Id")
	@GetMapping("/api/employees/{employeeId}")
	public Employee getEmployee(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@ApiOperation(value = "Add an employee")
	@PostMapping("/api/employees")
	public String saveEmployee(
			@ApiParam(value = "Employee object store in database table", required = true) @Valid @RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		log.debug("Employee Saved Successfully");
		return employee.getName();
	}

	@ApiOperation(value = "Delete an employee")
	@DeleteMapping("/api/employees/{employeeId}")
	public int deleteEmployee(
			@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true) @PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.deleteEmployee(employeeId);

	}

}
