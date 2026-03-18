package Assignment6_17March;



import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        IEmployeeService service = context.getBean(IEmployeeService.class);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Fetch By ID");
            System.out.println("5. Fetch All");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    service.createEmployee(new Employee(id, name, salary));
                    System.out.println("Added");
                    break;

                case 2:
                    System.out.print("ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Name: ");
                    String uname = sc.next();
                    System.out.print("Salary: ");
                    double usal = sc.nextDouble();

                    Employee updated = service.modifyEmployee(
                            new Employee(uid, uname, usal));

                    System.out.println(updated != null ? "Updated" : "Not Found");
                    break;

                case 3:
                    System.out.print("ID: ");
                    int did = sc.nextInt();

                    boolean deleted = service.removeEmployee(did);
                    System.out.println(deleted ? "Deleted" : "Not Found");
                    break;

                case 4:
                    System.out.print("ID: ");
                    int fid = sc.nextInt();

                    System.out.println(service.fetchEmployee(fid));
                    break;

                case 5:
                    service.fetchAll().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
        context.close();
    }
}
