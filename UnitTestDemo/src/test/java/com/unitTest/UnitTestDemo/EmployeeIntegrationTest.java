package com.unitTest.UnitTestDemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.unitTest.UnitTestDemo.controller.EmployeeRestController;
import com.unitTest.UnitTestDemo.entity.Employee;
import com.unitTest.UnitTestDemo.repository.EmployeeRepository;
import com.unitTest.UnitTestDemo.service.EmployeeService;
import com.unitTest.UnitTestDemo.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = UnitTest.class)
@ComponentScan(basePackages = "com.unitTest.UnitTestDemo.")
public class EmployeeIntegrationTest {
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Autowired
	private EmployeeService mockEmployeeService = new EmployeeServiceImpl();

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeRestController employeeRestController;
	/*
	 * @Test public void saveEmployeeTest() throws Exception { HttpEntity<String>
	 * entity = new HttpEntity<String>(null, headers);
	 * 
	 * ResponseEntity<String> response = restTemplate.exchange(
	 * 
	 * createURLWithPort("/api/employees"), HttpMethod.POST, entity, String.class);
	 * 
	 * String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
	 * 
	 * assertTrue(actual.contains("/api/employees"));
	 * 
	 * }
	 */

	private String createURLWithPort(String uri) {

		return "http://localhost:" + port + uri;

	}

	/*@Test
	public void getEmployeeTest() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(

				createURLWithPort("/api/employees/1"), HttpMethod.GET, entity, String.class);

		String expected = "{\"id\":1,\"name\":\"Sagar\",\"department\":\"comp\",\"salary\":10000}";

		JSONAssert.assertEquals(expected, response.getBody(), false);

	}*/
	/*static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/test";  

	static final String USER = "sa"; 
	   static final String PASS = ""; */


	@Test
	public void saveEmployeeTest()  throws Exception {
		
		Employee employee=new Employee();
		employee.setName("Sagar");
		employee.setDepartment("Comp");
		employee.setSalary(2000000);

		ResponseEntity<String> responseEntity =

				restTemplate.postForEntity(createURLWithPort("/api/employees/"),
						employee, String.class);

		String employeeResponse = responseEntity.getBody();
		

		//assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

		assertEquals("Sagar", employeeResponse);

	}
	@Test
	public void getEmployeeTest() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(

				createURLWithPort("/api/employees/1"), HttpMethod.GET, entity, String.class);

		String expected = "{\"id\":1,\"name\":\"Sagar\",\"department\":\"comp\",\"salary\":10000}";

		JSONAssert.assertEquals(expected, response.getBody(), false);

	}
	
/*	@Test
	public void getEmployeeTest() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(

				createURLWithPort("/api/employees/1"), HttpMethod.GET, entity, String.class);

		String expected = "{\"id\":1,\"name\":\"Sagar\",\"department\":\"comp\",\"salary\":2000000}";

		JSONAssert.assertEquals(expected, response.getBody(), false);

	}*/

}
