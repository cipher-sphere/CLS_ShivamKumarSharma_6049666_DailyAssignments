package com.example.demo.dto;

public class EmployeeDepartmentByMobileDTO {

    private Long employeeId;
    private String employeeName;
    private Long departmentId;
    private String departmentName;
    private String managerName;

    public EmployeeDepartmentByMobileDTO() {}

    public EmployeeDepartmentByMobileDTO(Long employeeId, String employeeName,
                                          Long departmentId, String departmentName, String managerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
}
