package com.example.demo.exception;

public class DepartmentNameNotFoundException extends RuntimeException {

    public DepartmentNameNotFoundException(String departmentName) {
        super("Department not found with name: " + departmentName);
    }
}
