package lk.ijse.eCommerce.dto;

public class SupplierPaymentDTO {

    private int spid;
    private double amount;
    private String date;
    private String paymentType;
    private String paymentDetails;
    private GRNDTO grndto;

    public SupplierPaymentDTO() {
    }

    public SupplierPaymentDTO(int spid, double amount, String date, String paymentType, String paymentDetails, GRNDTO grndto) {
        this.spid = spid;
        this.amount = amount;
        this.date = date;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.grndto = grndto;
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

    public GRNDTO getGrndto() {
        return grndto;
    }

    public void setGrndto(GRNDTO grndto) {
        this.grndto = grndto;
    }
}
