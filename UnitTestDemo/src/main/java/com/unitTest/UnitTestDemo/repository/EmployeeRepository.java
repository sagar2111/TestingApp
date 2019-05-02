package com.unitTest.UnitTestDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitTest.UnitTestDemo.entity.Employee;
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	@Query(
		    value = "SELECT * FROM EMPLOYEE WHERE id = ?1",
		    nativeQuery = true)
	Integer findByEif(@Param("id") Long employeeId);
}
