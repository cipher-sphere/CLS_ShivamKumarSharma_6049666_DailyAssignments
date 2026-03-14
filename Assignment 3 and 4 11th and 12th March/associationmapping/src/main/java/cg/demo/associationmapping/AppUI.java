package cg.demo.associationmapping;

import java.util.*;

public class AppUI {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n------ MENU ------");
            System.out.println("1 Insert Employee");
            System.out.println("2 Fetch all employees with department");
            System.out.println("3 Count employees per department");
            System.out.println("4 Employees by department");
            System.out.println("5 Department using mobile number");
            System.out.println("6 Get all Employees");
            System.out.println("7 Employees with salary greater than given");
            System.out.println("8 Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1: {

                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double sal = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter department name: ");
                    String deptName = sc.nextLine();

                    System.out.print("Enter manager name: ");
                    String mgr = sc.nextLine();

                    Department d = new Department();
                    d.setName(deptName);
                    d.setManagerName(mgr);

                    Employee e = new Employee();
                    e.setName(name);
                    e.setSalary(sal);

                    Set<String> mobiles = new HashSet<>();

                    System.out.print("Enter first mobile number: ");
                    mobiles.add(sc.nextLine());

                    System.out.print("Enter second mobile number: ");
                    mobiles.add(sc.nextLine());

                    e.setMobileNumbers(mobiles);
                    e.setDepartment(d);

                    Set<Employee> empSet = new HashSet<>();
                    empSet.add(e);

                    d.setEmployees(empSet);

                    dao.insertEmployee(e);

                    System.out.println("Employee inserted successfully!");

                    break;
                }

                case 2: {

                    List<Object[]> list = dao.fetchAllEmployees();

                    if (list.isEmpty()) {
                        System.out.println("No Records Found");
                    } else {

                        for (Object[] obj : list) {

                            System.out.println("--------------------------------");
                            System.out.println("Employee Name : " + obj[0]);
                            System.out.println("Department    : " + obj[1]);
                            System.out.println("Manager       : " + obj[2]);
                        }
                    }

                    break;
                }

                case 3: {

                    List<Object[]> list = dao.countEmployeesPerDept();

                    if (list.isEmpty()) {
                        System.out.println("No Records Found");
                    } else {

                        for (Object[] obj : list) {

                            System.out.println("--------------------------------");
                            System.out.println("Department : " + obj[0]);
                            System.out.println("Total Employees : " + obj[1]);
                        }
                    }

                    break;
                }

                case 4: {

                    System.out.print("Enter department name: ");
                    String dept = sc.nextLine();

                    List<Employee> list = dao.employeesByDepartment(dept);

                    if (list.isEmpty()) {
                        System.out.println("No Records Found");
                    } else {

                        for (Employee emp : list) {

                            System.out.println("--------------------------------");
                            System.out.println("ID: " + emp.getId());
                            System.out.println("Name: " + emp.getName());
                            System.out.println("Salary: " + emp.getSalary());
                        }
                    }

                    break;
                }

                case 5: {

                    System.out.print("Enter mobile number: ");
                    String mobile = sc.nextLine();

                    List<Object[]> list = dao.departmentByMobile(mobile);

                    if (list.isEmpty()) {
                        System.out.println("No Records Found");
                    } else {

                        for (Object[] obj : list) {

                            System.out.println("--------------------------------");
                            System.out.println("Employee ID : " + obj[0]);
                            System.out.println("Employee Name : " + obj[1]);
                            System.out.println("Department : " + obj[2]);
                        }
                    }

                    break;
                }

                case 6: {

                    List<Employee> list = dao.getAllEmployees();

                    if (list.isEmpty()) {
                        System.out.println("No Records Found");
                    } else {

                        for (Employee emp : list) {

                            System.out.println("--------------------------------");
                            System.out.println("ID: " + emp.getId());
                            System.out.println("Name: " + emp.getName());
                            System.out.println("Salary: " + emp.getSalary());
                            System.out.println("Mobiles: " + emp.getMobileNumbers());

                            Department d = emp.getDepartment();

                            if (d != null) {
                                System.out.println("Department: " + d.getName());
                                System.out.println("Manager: " + d.getManagerName());
                            }
                        }
                    }

                    break;
                }

                case 7: {

                    System.out.print("Enter Minimum Salary: ");
                    double minSalary = sc.nextDouble();

                    List<Employee> employees = dao.fetchEmployeeGreaterThanSalary(minSalary);

                    if (employees.isEmpty()) {
                        System.out.println("No Records Found");
                    } else {

                        for (Employee emp : employees) {

                            Department depart = emp.getDepartment();

                            System.out.println("--------------------------------");
                            System.out.println("ID: " + emp.getId());
                            System.out.println("Name: " + emp.getName());
                            System.out.println("Salary: " + emp.getSalary());
                            System.out.println("Mobiles: " + emp.getMobileNumbers());

                            if (depart != null) {
                                System.out.println("Department: " + depart.getName());
                                System.out.println("Manager: " + depart.getManagerName());
                            }
                        }
                    }

                    break;
                }

                case 8: {

                    System.out.println("Exiting application...");
                    dao.close();
                    sc.close();
                    System.exit(0);

                    break;
                }
                default:
                    System.out.println("Invalid Choice!");

            }
        }
    }
}