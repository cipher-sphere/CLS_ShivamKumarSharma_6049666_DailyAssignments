package cg.demo.jpahibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cg.demo.jpahibernate.entities.Employee;

public class EmployeeUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        System.out.println("Starting App!");

        while (true) {

            System.out.println("\n---- EMPLOYEE MENU ----");
            System.out.println("1 Insert Employee");
            System.out.println("2 Get Employee By Id");
            System.out.println("3 Update Salary");
            System.out.println("4 Delete Employee");
            System.out.println("5 Display Employee");
            System.out.println("6 Get Salary By Id");
            System.out.println("7 Employees By Salary");
            System.out.println("8 Employee Count By Department");
            System.out.println("9 Search Employee By Phone");
            System.out.println("10 Exit");
            //find my name
            //sorted one

            System.out.print("Enter choice : ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter name : ");
                    String name = sc.next();

                    System.out.print("Enter dept : ");
                    String dept = sc.next();

                    System.out.print("Enter salary : ");
                    double sal = sc.nextDouble();

                    System.out.print("How many phone numbers? ");
                    int n = sc.nextInt();

                    List<Long> phones = new ArrayList<>();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter phone " + (i + 1) + " : ");
                        phones.add(sc.nextLong());
                    }

                    Employee emp = new Employee();
                    emp.setName(name);
                    emp.setDept(dept);
                    emp.setSalary(sal);
                    emp.setPhoneno(phones);

                    dao.insertEmployee(emp);

                    System.out.println("Employee inserted successfully");

                    break;

                case 2:

                    System.out.print("Enter id : ");
                    int eid = sc.nextInt();

                    Employee e = dao.getEmployeeById(eid);

                    if (e != null)
                        System.out.println(e);
                    else
                        System.out.println("Employee not found");

                    break;

                case 3:

                    System.out.print("Enter id : ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new salary : ");
                    double newsal = sc.nextDouble();

                    Employee updated = dao.updateSalary(uid, newsal);

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
                        System.out.println("Employee deleted successfully");
                    else
                        System.out.println("Employee not found");

                    break;

                case 5:

                    List<Employee> list = dao.getAllEmployees();

                    if (list.isEmpty()) {
                        System.out.println("No employees found");
                    } 
                    else {
                        for (Employee x : list) {
                            System.out.println(x);
                        }
                    }

                    break;

                case 6:

                    System.out.print("Enter id : ");
                    int sid = sc.nextInt();

                    Double salary = dao.getSalaryById(sid);

                    System.out.println("Salary = " + salary);

                    break;

                case 7:

                    System.out.print("Enter salary : ");
                    double s = sc.nextDouble();

                    List<Employee> salList = dao.getEmployeeBySalary(s);

                    for (Employee x : salList) {
                        System.out.println(x);
                    }

                    break;

                case 8:

                    List<Object[]> deptList = dao.getEmployeeCountByDept();

                    for (Object[] obj : deptList) {
                        System.out.println("Dept : " + obj[0] + "  Count : " + obj[1]);
                    }

                    break;

                case 9:

                    System.out.print("Enter phone number : ");
                    long ph = sc.nextLong();

                    List<Employee> phoneList = dao.getEmployeeByPhone(ph);

                    for (Employee x : phoneList) {
                        System.out.println(x);
                    }

                    break;

                case 10:

                    System.out.println("Program ended");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}