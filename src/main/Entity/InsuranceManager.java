package Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

/**
 * @author
 * @version ${}
 * @created 25/04/2024 11:59
 * @project Team6_InsuranceApplication_FurtherProgramming
 */
@Entity
@Table(name = "INSURANCE_MANAGER", schema = "public", catalog = "postgres")
public class InsuranceManager {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "insuranceManager")
    private Collection<Claim> listOfClams;
    @OneToMany(mappedBy = "insuranceManager")
    private Collection<InsuranceSurveyor> listOfSurveyors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceManager that = (InsuranceManager) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, address, phoneNumber);
    }

    public Collection<Claim> getListOfClams() {
        return listOfClams;
    }

    public void setListOfClams(Collection<Claim> listOfClams) {
        this.listOfClams = listOfClams;
    }

    public Collection<InsuranceSurveyor> getListOfSurveyors() {
        return listOfSurveyors;
    }

    public void setListOfSurveyors(Collection<InsuranceSurveyor> listOfSurveyors) {
        this.listOfSurveyors = listOfSurveyors;
    }
}
