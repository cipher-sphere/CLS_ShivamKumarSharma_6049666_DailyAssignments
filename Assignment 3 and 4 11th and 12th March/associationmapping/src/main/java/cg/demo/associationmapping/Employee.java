package cg.demo.associationmapping;

import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double salary;

    @ElementCollection
    private Set<String> mobileNumbers;

    // FIX: add cascade
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    public int getId() { 
        return id; 
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public double getSalary() { 
        return salary; 
    }

    public void setSalary(double salary) { 
        this.salary = salary; 
    }

    public Set<String> getMobileNumbers() { 
        return mobileNumbers; 
    }

    public void setMobileNumbers(Set<String> mobileNumbers) { 
        this.mobileNumbers = mobileNumbers; 
    }

    public Department getDepartment() { 
        return department; 
    }

    public void setDepartment(Department department) { 
        this.department = department; 
    }
}