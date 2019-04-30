package com.unitTest.UnitTestDemo.service;

import java.util.List;

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
}
