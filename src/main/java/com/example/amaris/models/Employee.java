package com.example.amaris.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private Long id;
    private String employee_name;
    private Long employee_salary;
    private String employee_salary_converted;
    private int employee_age;
    private String profile_image;
    private String employee_anual_salary;

    public Employee(Long id, String employee_name, Long employee_salary, int employee_age, String profile_image, String employee_anual_salary) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
        this.employee_anual_salary = employee_anual_salary;
    }

    public String getEmployee_salary_converted() {
        return employee_salary_converted;
    }

    public void setEmployee_salary_converted(String employee_salary_converted) {
        this.employee_salary_converted = employee_salary_converted;
    }

    public String getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public void setEmployee_anual_salary(String employee_anual_salary) {
        this.employee_anual_salary = employee_anual_salary;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    public Long getEmployee_salary() {
        return employee_salary;
    }
    public void setEmployee_salary(Long employee_salary) {
        this.employee_salary = employee_salary;
    }
    public int getEmployee_age() {
        return employee_age;
    }
    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }
    public String getProfile_image() {
        return profile_image;
    }
    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
    

    
}
