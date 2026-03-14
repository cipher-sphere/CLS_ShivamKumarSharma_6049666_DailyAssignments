

package cg.demo.jpahibernate.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String dept;
    private double salary;

    @ElementCollection
    private List<Long> phoneno;

    // Default constructor (required by JPA)
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String name, String dept, double salary, List<Long> phoneno) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.phoneno = phoneno;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Long> getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(List<Long> phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name +
               ", dept=" + dept + ", salary=" + salary +
               ", phoneno=" + phoneno + "]";
    }
}

//@Entity

//@Table(name="")
//@Column(name="")

//@GeneratedValue    ...single sequence created ..automatic id generate for all entities
//@GeneratedValue(strategy=GenerationType.IDENTITY)....will create new sequence for different entities

//@ElementCollection....apply on wrapper/UserDefined type collection..
//@Embeddable.....Used to create a reusable class whose fields become part of another entity table.
// for mobile  we need to pass full set
// Separate tables get created
//| Feature       | @ElementCollection  | @Embeddable          |
//| ------------- | ------------------- | -------------------- |
//| Used for      | Collection values   | Object inside entity |
//| Table created | Yes                 | No                   |
//| Example       | List<String> skills | Address object       |


//Validation annotation
//| Annotation      | Use                    |
//| --------------- | ---------------------- |
//| `@NotNull`      | Value cannot be null   |
//| `@NotBlank`     | String cannot be empty |
//| `@Size`         | Length restriction     |
//| `@Min` / `@Max` | Numeric range          |
//| `@Email`        | Valid email            |
//| `@Pattern`      | Regex validation       |


//@Transient  ...Do NOT store this field in the database table.



//Regex

//| Symbol  | Meaning         | Example |
//| ------- | --------------- | ------- |
//| `.`     | Any character   | `a.c`   |
//| `*`     | 0 or more       | `ab*`   |
//| `+`     | 1 or more       | `ab+`   |
//| `?`     | Optional        | `ab?`   |
//| `[abc]` | a or b or c     | `[abc]` |
//| `[A-Z]` | Capital letters | `[A-Z]` |
//| `[0-9]` | Digits          | `[0-9]` |
//| `^`     | Start of string | `^abc`  |
//| `$`     | End of string   | `abc$`  |


//@Pattern(regexp="^[0-9]{10}$")
//private String phoneno;