package com.example.amaris.services;

import java.io.StringReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.amaris.models.Employee;
import com.example.amaris.models.ListModel;
import com.example.amaris.models.UniqueModel;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@Service
public class EmployeeService {

    final String URL = "http://dummy.restapiexample.com/api/v1/employees/";

    public Employee getEmployee(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Gson g = new Gson();
        ResponseEntity<String> respStr = restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employee/" + id,
                HttpMethod.GET, entity, String.class);
        JsonReader reader = new JsonReader(new StringReader(respStr.getBody().toString()));
        reader.setLenient(true);
        UniqueModel rm = g.fromJson(reader, UniqueModel.class);
        Employee e = rm.getEmployee();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(e.getEmployee_salary());
        e.setEmployee_salary_converted(moneyString);
        e.setEmployee_anual_salary(this.calculateAnualSalary(e.getEmployee_salary()));
        return e;

    }

    public Employee[] getEmployees() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Gson g = new Gson();
        ResponseEntity<String> respStr = restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employees/",
                HttpMethod.GET, entity, String.class);
        JsonReader reader = new JsonReader(new StringReader(respStr.getBody().toString()));
        reader.setLenient(true);
        ListModel rm = g.fromJson(reader, ListModel.class);
        // Employee a= new Employee(1L, "Juan", 630000l, 23, "", "");
        // Employee b= new Employee(2L, "Fernando", 10000l, 32, "","");
        // Employee[] e = {a,b};
        // Employee[] employeesList = e;
        Employee[] employeesList = rm.getEmployee();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for (Employee employee : employeesList) {

            String moneyString = formatter.format(employee.getEmployee_salary());
            employee.setEmployee_salary_converted(moneyString);
            employee.setEmployee_anual_salary(this.calculateAnualSalary(employee.getEmployee_salary()));
        }
        return employeesList;
    }

    public String calculateAnualSalary(Long value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(value * 12);
        return moneyString;
    }
}
