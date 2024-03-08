package lk.icbt.labappointmentsystem.models;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceId;
    private String productDescription;
    private BigDecimal amount;

    private String createdBy;
    private Timestamp createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "invoice")
    private Set<Reservation> reservationList;

    public Invoice(Long invoiceId, String productDescription, BigDecimal amount, String createdBy, Timestamp createdDate, User user, Set<Reservation> reservationList) {
        this.invoiceId = invoiceId;
        this.productDescription = productDescription;
        this.amount = amount;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.user = user;
        this.reservationList = reservationList;
    }

    public Invoice() {
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(Set<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
