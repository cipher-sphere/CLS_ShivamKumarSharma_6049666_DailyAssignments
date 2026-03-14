package cg.demo.associationmapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class Citizen {

    @Id
    private int adharNo;

    private String name;
    private String address;

    @OneToOne(mappedBy = "citizen", cascade = CascadeType.ALL)
    private IndianPassport passport;

    // Default Constructor
    public Citizen() {}

    // Parameterized Constructor
    public Citizen(int adharNo, String name, String address) {
        this.adharNo = adharNo;
        this.name = name;
        this.address = address;
    }

    public int getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(int adharNo) {
        this.adharNo = adharNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public IndianPassport getPassport() {
        return passport;
    }

    public void setPassport(IndianPassport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Citizen [adharNo=" + adharNo +
               ", name=" + name +
               ", address=" + address + "]";
    }
}