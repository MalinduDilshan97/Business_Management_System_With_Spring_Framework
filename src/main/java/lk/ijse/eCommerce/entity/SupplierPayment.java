package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
public class SupplierPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spid;
    private double amount;
    private String date;
    private String paymentType;
    private String paymentDetails;
    @OneToOne
    @JoinColumn(name = "grnId")
    private GRN grn;

    public SupplierPayment() {
    }

    public SupplierPayment(double amount, String date, String paymentType, String paymentDetails, GRN grn) {
        this.amount = amount;
        this.date = date;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.grn = grn;
    }

    public SupplierPayment(int spid, double amount, String date, String paymentType, String paymentDetails, GRN grn) {
        this.spid = spid;
        this.amount = amount;
        this.date = date;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.grn = grn;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public GRN getGrn() {
        return grn;
    }

    public void setGrn(GRN grn) {
        this.grn = grn;
    }
}
