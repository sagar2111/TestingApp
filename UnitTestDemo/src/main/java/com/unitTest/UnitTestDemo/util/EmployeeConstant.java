package com.unitTest.UnitTestDemo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeConstant {
	S200("Execution Successfull."), S400("Exception Occured While Proccessing"),OBJECT_NOT_FOUND("Record Not Found");

	private String message;

}
