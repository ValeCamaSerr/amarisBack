package com.example.amaris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.amaris.controllers.EmployeeController;
import com.example.amaris.models.Employee;
import com.example.amaris.services.EmployeeService;

@SpringBootTest
class AmarisApplicationTests {

	private MockMvc mockMvc;
	
	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		this.employeeService = new EmployeeService();
	}

	@Test
	public void testCalculateAnualSalary(){
		Long value = 100l;
		String a = employeeService.calculateAnualSalary(value);
		Assertions.assertEquals("$ 1.200,00",a);
	}

	@Test
	public void testGetEmployees(){
		Employee[] e = employeeService.getEmployees();
		Assertions.assertNotNull(e);
	}

	@Test
	public void testGetEmployee(){
		Long value = 1L;
		Employee e = employeeService.getEmployee(value);
		Assertions.assertNotNull(e);
	}
}
