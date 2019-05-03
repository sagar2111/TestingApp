package com.unitTest.UnitTestDemo.service;

import java.util.List;

import com.unitTest.UnitTestDemo.DTO.EmployeeRequest;
import com.unitTest.UnitTestDemo.DTO.EmployeeResponse;
import com.unitTest.UnitTestDemo.entity.Employee;

/**
 * @author sagar
 *
 */
public interface EmployeeService {

	public Employee getEmployee(Long employeeId);

	public Long saveEmployee(Employee employee);

	public int deleteEmployee(Long employeeId);

	public String updateEmployee(Employee employee);

	public EmployeeResponse getEmployeeResponse(Long employeeId);

	public EmployeeResponse saveEmployeeRequest(EmployeeRequest EmployeeRequest);

	public Integer getEmployeeIdInt(Long employeeId);

	String sendMessage(Employee emp);
}
