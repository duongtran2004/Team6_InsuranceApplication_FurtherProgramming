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
public class Beneficiaries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "address")
    private String policyOwnerByPolicyOwnerId;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "policy_holder_id", referencedColumnName = "id", nullable = false)
    private Beneficiaries policyHolder;
    @OneToMany(mappedBy = "policyHolder")
    private Collection<Beneficiaries> listOfDependants;
    @ManyToOne
    @JoinColumn(name = "policy_owner_id", referencedColumnName = "id", nullable = false)
    private PolicyOwner policyOwner;
    @ManyToOne
    @JoinColumn(name = "card_number", referencedColumnName = "card_number", nullable = false)
    private InsuranceCard insuranceCard;
    @OneToMany(mappedBy = "insuredPerson")
    private Collection<Claim> listOfClaims;

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

    public String getPolicyOwnerByPolicyOwnerId() {
        return policyOwnerByPolicyOwnerId;
    }

    public void setPolicyOwnerByPolicyOwnerId(String policyOwnerByPolicyOwnerId) {
        this.policyOwnerByPolicyOwnerId = policyOwnerByPolicyOwnerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiaries that = (Beneficiaries) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(policyOwnerByPolicyOwnerId, that.policyOwnerByPolicyOwnerId) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, policyOwnerByPolicyOwnerId, phoneNumber, email, password, type);
    }

    public Beneficiaries getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(Beneficiaries policyHolder) {
        this.policyHolder = policyHolder;
    }

    public Collection<Beneficiaries> getListOfDependants() {
        return listOfDependants;
    }

    public void setListOfDependants(Collection<Beneficiaries> listOfDependants) {
        this.listOfDependants = listOfDependants;
    }

    public PolicyOwner getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(PolicyOwner policyOwner) {
        this.policyOwner = policyOwner;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public Collection<Claim> getListOfClaims() {
        return listOfClaims;
    }

    public void setListOfClaims(Collection<Claim> listOfClaims) {
        this.listOfClaims = listOfClaims;
    }
}
