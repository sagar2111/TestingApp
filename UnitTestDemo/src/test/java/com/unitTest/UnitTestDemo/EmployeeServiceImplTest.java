package com.unitTest.UnitTestDemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when; // ...or...

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.repository.EmployeeRepository;
import com.unitTest.UnitTestDemo.service.EmployeeService;
import com.unitTest.UnitTestDemo.service.EmployeeServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	private EmployeeService mockEmployeeService = new EmployeeServiceImpl();

	@Mock
	private static EmployeeRepository employeeRepository;

	@Test
	public void getEmployeeTestForRepository() {
		Long employeeId = 1L;
		Employee emp2 = new Employee(employeeId, "ABC", 423534, "fsd");
		when(employeeRepository.findById(1L)).thenReturn(createTestEntity());
		Employee resultEmployee = mockEmployeeService.getEmployee(employeeId);
		// Assert.assertEquals(1L,actual.getId());
		assertEquals(new Long(1), resultEmployee.getId());
		Assert.assertNotNull(resultEmployee);

	}

	private static Optional<Employee> createTestEntity() {
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setName("sagar");
		emp.setSalary(423423);
		emp.setDepartment("Copm");

		return Optional.of(emp);
	}

	@Test
	public void addEmployeeDetailTest() {
		//create conection
		
		Employee dummyEmployee = new Employee(1L, "sagar_result", 20000, "Comp");
		Employee inputEmployee = new Employee(null, "sagar", 20000, "Comp");
		when(employeeRepository.saveAndFlush(inputEmployee)).thenReturn(dummyEmployee);
		Long resultEmployeeId = mockEmployeeService.saveEmployee(inputEmployee);
		
		assertEquals(dummyEmployee.getId(), resultEmployeeId);
	}
	@Test
	public void deleteEmployeeTest() {
		
	    Employee dummyEmployee = new Employee(1L, "sagar_result", 20000, "Comp");
		Employee inputEmployee = new Employee(1L, "sagar", 20000, "Comp");
	    when(employeeRepository.findById(1L)).thenReturn(Optional.of(inputEmployee));
	    mockEmployeeService.deleteEmployee(1L);
	   //verify(employeeRepository, times(1)).delete(dummyEmployee.getId());


	}

}
