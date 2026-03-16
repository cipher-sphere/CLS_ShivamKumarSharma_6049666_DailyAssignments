package cg.demos.springcore.problem2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring2.xml");

        Employee emp = (Employee) context.getBean("emp1");

        emp.displayEmployeeDetails();
    }
}