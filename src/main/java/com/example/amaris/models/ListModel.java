package com.example.amaris.models;

public class ListModel extends ResponseModel{
    
    private Employee[] data;

    public ListModel(String status, String message) {
        super(status, message);
    }

    public Employee[] getEmployee() {
        return data;
    }

    public void setEmployee(Employee[] data) {
        this.data = data;
    }
}
