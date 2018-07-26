package lk.ijse.eCommerce.dto;


public class CustomerPaymentDTO {

    private int cpid;
    private double amount;
    private String paymentType;
    private String paymentDetails;
    private String date;
    private CustomerOrderDTO customerOrderDTO;

    public CustomerPaymentDTO() {
    }

    public CustomerPaymentDTO(double amount, String paymentType, String paymentDetails, String date, CustomerOrderDTO customerOrderDTO) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.date = date;
        this.customerOrderDTO = customerOrderDTO;
    }

    public CustomerPaymentDTO(int cpid, double amount, String paymentType, String paymentDetails, String date, CustomerOrderDTO customerOrderDTO) {
        this.cpid = cpid;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.date = date;
        this.customerOrderDTO = customerOrderDTO;
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

    public CustomerOrderDTO getCustomerOrderDTO() {
        return customerOrderDTO;
    }

    public void setCustomerOrderDTO(CustomerOrderDTO customerOrderDTO) {
        this.customerOrderDTO = customerOrderDTO;
    }
}
