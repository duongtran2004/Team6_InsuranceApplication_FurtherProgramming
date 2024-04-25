package Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

/**
 * @author
 * @version ${}
 * @created 25/04/2024 11:59
 * @project Team6_InsuranceApplication_FurtherProgramming
 */
@Entity
@Table(name = "INSURANCE_CARD", schema = "public", catalog = "postgres")
public class InsuranceCard {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "card_number")
    private String cardNumber;
    @Basic
    @Column(name = "expiration_date")
    private Date expirationDate;
    @OneToMany(mappedBy = "insuranceCard")
    private Collection<Beneficiaries> insuredPeople;
    @OneToMany(mappedBy = "insuranceCard")
    private Collection<Claim> claimsByCardNumber;
    @ManyToOne
    @JoinColumn(name = "policy_owner_id", referencedColumnName = "id", nullable = false)
    private PolicyOwner policyOwnerByPolicyOwnerId;
    @OneToOne
    @JoinColumn(name = "card_holder_id", referencedColumnName = "id", nullable = false)
    private Beneficiaries cardHolder;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceCard that = (InsuranceCard) o;
        return Objects.equals(cardNumber, that.cardNumber) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, expirationDate);
    }

    public Collection<Beneficiaries> getInsuredPeople() {
        return insuredPeople;
    }

    public void setInsuredPeople(Collection<Beneficiaries> insuredPeople) {
        this.insuredPeople = insuredPeople;
    }

    public Collection<Claim> getClaimsByCardNumber() {
        return claimsByCardNumber;
    }

    public void setClaimsByCardNumber(Collection<Claim> claimsByCardNumber) {
        this.claimsByCardNumber = claimsByCardNumber;
    }

    public PolicyOwner getPolicyOwnerByPolicyOwnerId() {
        return policyOwnerByPolicyOwnerId;
    }

    public void setPolicyOwnerByPolicyOwnerId(PolicyOwner policyOwnerByPolicyOwnerId) {
        this.policyOwnerByPolicyOwnerId = policyOwnerByPolicyOwnerId;
    }

    public Beneficiaries getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Beneficiaries cardHolder) {
        this.cardHolder = cardHolder;
    }
}
