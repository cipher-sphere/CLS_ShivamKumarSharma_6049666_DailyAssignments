package com.example.demo.dto;

public class DepartmentEmployeeCountDTO {

    private String departmentName;
    private Long employeeCount;

    public DepartmentEmployeeCountDTO() {}

    public DepartmentEmployeeCountDTO(String departmentName, Long employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public Long getEmployeeCount() { return employeeCount; }
    public void setEmployeeCount(Long employeeCount) { this.employeeCount = employeeCount; }
}
