package com.unitTest.UnitTestDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitTest.UnitTestDemo.DTO.Response;
import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	

	public Employee getEmployee(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
				return optEmp.get();
	}

	public Long saveEmployee(Employee employee) {
		return employeeRepository.saveAndFlush(employee).getId();
	}

	public int deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return 1;
	}

	public String updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee.getName();
	}

	@Override
	public Response getEmployeeResponse(Long employeeId) {
		Response response=new Response();
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		//Employee emp=Optional.of(optEmp);
 		return null;
	}
}
