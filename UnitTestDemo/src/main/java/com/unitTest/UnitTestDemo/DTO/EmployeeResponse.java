package com.unitTest.UnitTestDemo.DTO;



import java.util.List;

import org.springframework.stereotype.Component;

import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.util.EmployeeConstant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmployeeResponse {
	private String message;
	private List<Employee> empList;
	private int data;
	private EmployeeConstant status;
	private String statusDescription;
}
