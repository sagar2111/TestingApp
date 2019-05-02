package com.unitTest.UnitTestDemo.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.unitTest.UnitTestDemo.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmployeeRequest {
	private String message;
	private List<Employee> empList;
	private int data;
}