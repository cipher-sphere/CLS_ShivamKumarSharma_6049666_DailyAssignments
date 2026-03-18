package Assignment7;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Assignment7.xml");

        SBU sbu = (SBU) context.getBean("sbu");

        

        System.out.println("SBU details");
        System.out.println();

        System.out.println(sbu);

        
    }
}