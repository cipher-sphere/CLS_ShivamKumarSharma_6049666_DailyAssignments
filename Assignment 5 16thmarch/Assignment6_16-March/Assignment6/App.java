package Assignment6;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Assignment6.xml");

        UpdatedEmployee emp = (UpdatedEmployee) context.getBean("emp");

        

        System.out.println("Employee details");
        System.out.println();

        System.out.println(emp);

        
    }
}