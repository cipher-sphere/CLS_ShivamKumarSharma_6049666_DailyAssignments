package com.demo.jdbc2;

public class Employee {

    private int id;
    private String dept;
    private String name;
    private long phoneno;
    private double salary;
    
    public Employee() {
    }

    public Employee(int id, String dept, String name, long phoneno, double salary) {
        this.id = id;
        this.dept = dept;
        this.name = name;
        this.phoneno = phoneno;
        this.salary = salary;
    }
   
	public int getId() { return id; }
    public String getDept() { return dept; }
    public String getName() { return name; }
    public long getPhoneno() { return phoneno; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}