package com.demo.jdbc2;

import java.util.Scanner;
import java.util.List;
import java.sql.SQLException;

public class EmployeeUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        try {

            dao.createTable();

            int choice;

            while (true) {

                System.out.println("\n---- EMPLOYEE MENU ----");
                System.out.println("1 Insert Employee");
                System.out.println("2 Get Employee By Id");
                System.out.println("3 Update Salary");
                System.out.println("4 Delete Employee");
                System.out.println("5 Display Employees");
                System.out.println("6 Exit");

                System.out.print("Enter choice : ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter id : ");
                        int id = sc.nextInt();

                        System.out.print("Enter dept : ");
                        String dept = sc.next();

                        System.out.print("Enter name : ");
                        String name = sc.next();

                        System.out.print("Enter phone : ");
                        long phone = sc.nextLong();

                        System.out.print("Enter salary : ");
                        double sal = sc.nextDouble();

                        Employee emp = new Employee(id, dept, name, phone, sal);

                        Employee inserted = dao.insertEmployee(emp);

                        if (inserted != null)
                            System.out.println("Employee inserted");
                        else
                            System.out.println("Insert failed");

                        break;

                    case 2:

                        System.out.print("Enter id : ");
                        int eid = sc.nextInt();

                        Employee e = dao.getEmployeeById(eid);

                        if (e != null)
                            System.out.println(e.getId()+" "+e.getDept()+" "+e.getName()+" "+e.getPhoneno()+" "+e.getSalary());
                        else
                            System.out.println("Employee not found");

                        break;

                    case 3:

                        System.out.print("Enter id : ");
                        int uid = sc.nextInt();

                        System.out.print("Enter new salary : ");
                        double newsal = sc.nextDouble();

                        Employee empUpdate = new Employee();   // renamed variable
                        empUpdate.setSalary(newsal);

                        Employee updated = dao.updateSalary(uid, empUpdate);

                        if (updated != null)
                            System.out.println("Salary updated to: " + updated.getSalary());
                        else
                            System.out.println("Employee not found");

                        break;

                    case 4:

                        System.out.print("Enter id : ");
                        int did = sc.nextInt();

                        Employee deleted = dao.deleteEmployee(did);

                        if (deleted != null)
                            System.out.println("Employee deleted");
                        else
                            System.out.println("Employee not found");

                        break;

                    case 5:

                        List<Employee> list = dao.getAllEmployees();

                        for (Employee x : list) {
                            System.out.println(
                                    x.getId()+" "+
                                    x.getDept()+" "+
                                    x.getName()+" "+
                                    x.getPhoneno()+" "+
                                    x.getSalary());
                        }

                        break;

                    case 6:

                        System.out.println("Program ended");
                        sc.close();
                        System.exit(0);
                }
            }

        } catch (SQLException ex) {

            System.out.println("Database error: " + ex.getMessage());
        }
    }
}