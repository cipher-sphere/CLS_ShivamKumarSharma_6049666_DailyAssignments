package com.example.demo.dto;

import java.util.Set;

public class EmployeeWithDepartmentDTO {

    private Long employeeId;
    private String employeeName;
    private Double salary;
    private Set<String> mobileNumbers;
    private String departmentName;
    private String managerName;

    public EmployeeWithDepartmentDTO() {}

    public EmployeeWithDepartmentDTO(Long employeeId, String employeeName, Double salary,
                                     Set<String> mobileNumbers, String departmentName, String managerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.mobileNumbers = mobileNumbers;
        this.departmentName = departmentName;
        this.managerName = managerName;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Set<String> getMobileNumbers() { return mobileNumbers; }
    public void setMobileNumbers(Set<String> mobileNumbers) { this.mobileNumbers = mobileNumbers; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
}
