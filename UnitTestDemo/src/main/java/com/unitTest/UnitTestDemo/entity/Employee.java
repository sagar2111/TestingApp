package com.unitTest.UnitTestDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sagar
 *
 */
@Entity
@Table(name = "EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "All details about the Employee. ")
public class Employee {
	@ApiModelProperty(notes = "The database generated employee ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes = "The database generated employee ID")
	@Column(name = "EMPLOYEE_NAME")
	private String name;
	@ApiModelProperty(notes = "The database generated employee ID")
	@Column(name = "EMPLOYEE_SALARY")
	private Integer salary;
	@ApiModelProperty(notes = "The database generated employee ID")
	@Column(name = "DEPARTMENT")
	private String department;

}
