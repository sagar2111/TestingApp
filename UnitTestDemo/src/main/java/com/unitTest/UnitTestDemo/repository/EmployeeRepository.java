package com.unitTest.UnitTestDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unitTest.UnitTestDemo.entity.Employee;
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
 
}
