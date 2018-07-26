package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
public class CustomerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cpid;
    private double amount;
    private String paymentType;
    private String paymentDetails;
    private String date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coid")
    private CustomerOrder customerOrder;

    public CustomerPayment() {
    }

    public CustomerPayment(double amount, String paymentType, String paymentDetails, String date, CustomerOrder customerOrder) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.date = date;
        this.customerOrder = customerOrder;
    }

    public CustomerPayment(int cpid, double amount, String paymentType, String paymentDetails, String date, CustomerOrder customerOrder) {
        this.cpid = cpid;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.date = date;
        this.customerOrder = customerOrder;
    }

    public int getCpid() {
        return cpid;
    }

    public void setCpid(int cpid) {
        this.cpid = cpid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
