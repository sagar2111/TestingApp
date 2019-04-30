package com.unitTest.UnitTestDemo.DTO;

import java.util.List;

import com.unitTest.UnitTestDemo.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	String message;
	List<Employee> empList;
	int data;
}
