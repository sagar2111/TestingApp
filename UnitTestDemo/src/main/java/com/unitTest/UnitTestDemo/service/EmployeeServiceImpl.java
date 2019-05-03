package com.unitTest.UnitTestDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.unitTest.UnitTestDemo.DTO.EmployeeRequest;
import com.unitTest.UnitTestDemo.DTO.EmployeeResponse;
import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.repository.EmployeeRepository;
import com.unitTest.UnitTestDemo.util.EmployeeConstant;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RabbitMQSender rabbitMQSender;

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
		employeeRepository.saveAndFlush(employee);
		return employee.getName();
	}

	@Override
	public EmployeeResponse getEmployeeResponse(Long employeeId) {
		EmployeeResponse response = new EmployeeResponse();
		List<Employee> emp = new ArrayList<>();
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		if (optEmp.isPresent()) {
			emp.add(optEmp.get());
			response.setEmpList(emp);
			response.setStatus(EmployeeConstant.S200);
			response.setStatusDescription(EmployeeConstant.S200.toString());

		} else {
			response.setStatus(EmployeeConstant.S200);
			response.setStatusDescription(EmployeeConstant.OBJECT_NOT_FOUND.toString());

		}
		return response;
	}

	@Override
	public EmployeeResponse saveEmployeeRequest(EmployeeRequest request) {
		EmployeeResponse response = new EmployeeResponse();
		if (request.getEmpList().get(0).getName() == null || request.getEmpList().get(0).getDepartment().isEmpty()) {
			response.setStatusDescription("Employee Name Cannot Be Empty");

		} else if (request.getEmpList().get(0).getDepartment() == null
				|| request.getEmpList().get(0).getDepartment().isEmpty()) {
			response.setStatusDescription("Employee Department Cannot Be Empty");
		}
		if (request.getEmpList().get(0).getSalary() == null) {
			response.setStatusDescription("Employee Salary Cannot Be Empty");
		} else {
			employeeRepository.save(request.getEmpList().get(0));
			response.setStatus(EmployeeConstant.S200);
			response.setStatusDescription(EmployeeConstant.S200.getMessage());
		}
		return response;
	}

	@Override
	public Integer getEmployeeIdInt(Long employeeId) {
		return employeeRepository.findByEif(employeeId);
	}

	@Override
	public String sendMessage(Employee emp) {
		rabbitMQSender.send(emp);
		return "Message sent to the RabbitMQ  Successfully";
	}
}
