package cg.demo.associationmapping;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class IndianPassport {

    @Id
    private int passportNo;

    private LocalDate passportExpiryDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Citizen citizen;

    // Default Constructor
    public IndianPassport() {}

    // Parameterized Constructor
    public IndianPassport(int passportNo, LocalDate passportExpiryDate, Citizen citizen) {
        this.passportNo = passportNo;
        this.passportExpiryDate = passportExpiryDate;
        this.citizen = citizen;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public LocalDate getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public void setPassportExpiryDate(LocalDate passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return "IndianPassport [passportNo=" + passportNo +
               ", passportExpiryDate=" + passportExpiryDate + "]";
    }
}