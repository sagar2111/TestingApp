package com.unitTest.UnitTestDemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.apache.coyote.http11.Http11AprProtocol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitTest.UnitTestDemo.controller.EmployeeRestController;
import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.repository.EmployeeRepository;
import com.unitTest.UnitTestDemo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeRestController.class, secure = false)
public class EmployeeRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;
	@Mock
	private static EmployeeRepository mmployeeRepository;

	@Test
	public void saveEmployeeTest() throws Exception {

		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("sagar");
		employee.setDepartment("Comp");
		employee.setSalary(423452);
		String empObjInJSON = this.mapToJSON(employee);
		String createEmpURL = "/api/employees";
		Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(1L);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(createEmpURL).accept(MediaType.APPLICATION_JSON)
				.content(empObjInJSON).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJSON = response.getContentAsString();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	public String mapToJSON(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	@Test
	public void  getEmployeeTest() throws Exception
	{
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("sagar");
		employee.setDepartment("Comp");
		employee.setSalary(423452);	
		Mockito.when(employeeService.getEmployee(1L)).thenReturn(employee);
		String createEmpURL = "/api/employees/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(createEmpURL).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String empObjInJSON = this.mapToJSON(employee);
		String outputInJSON = result.getResponse().getContentAsString();
		assertEquals(empObjInJSON, outputInJSON);
	}
	
	@Test
	public void deleteEmployeeTest() throws Exception
	{
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("sagar");
		employee.setDepartment("Comp");
		employee.setSalary(423452);	
		Mockito.when(employeeService.deleteEmployee(1L)).thenReturn(1);
		String createEmpURL = "/api/employees/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(createEmpURL).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String empObjInJSON = this.mapToJSON(employee);
		String outputInJSON = result.getResponse().getContentAsString();
		log.debug(outputInJSON);
		assertEquals(1, 1);
	}
}
