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
@Table(name = "POLICY_OWNER", schema = "public", catalog = "postgres")
public class PolicyOwner {
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
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "policyOwner")
    private Collection<Beneficiaries> listOfBeneficiaries;
    @OneToMany(mappedBy = "policyOwner")
    private Collection<Claim> listOfClaims;
    @OneToMany(mappedBy = "policyOwnerByPolicyOwnerId")
    private Collection<InsuranceCard> listOfInsuranceCard;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicyOwner that = (PolicyOwner) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, address, phoneNumber, password);
    }

    public Collection<Beneficiaries> getListOfBeneficiaries() {
        return listOfBeneficiaries;
    }

    public void setListOfBeneficiaries(Collection<Beneficiaries> listOfBeneficiaries) {
        this.listOfBeneficiaries = listOfBeneficiaries;
    }

    public Collection<Claim> getListOfClaims() {
        return listOfClaims;
    }

    public void setListOfClaims(Collection<Claim> listOfClaims) {
        this.listOfClaims = listOfClaims;
    }

    public Collection<InsuranceCard> getListOfInsuranceCard() {
        return listOfInsuranceCard;
    }

    public void setListOfInsuranceCard(Collection<InsuranceCard> listOfInsuranceCard) {
        this.listOfInsuranceCard = listOfInsuranceCard;
    }
}
