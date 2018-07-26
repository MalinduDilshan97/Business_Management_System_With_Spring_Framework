package lk.ijse.eCommerce.dto;

public class CustomerOrderDetailsDTO {

    private double unitPrice;
    private int orderQty;
    private int iCode;
    private int batchId;

    public CustomerOrderDetailsDTO() {
    }

    public CustomerOrderDetailsDTO(double unitPrice, int orderQty, int iCode, int batchId) {
        this.unitPrice = unitPrice;
        this.orderQty = orderQty;
        this.iCode = iCode;
        this.batchId = batchId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public int getiCode() {
        return iCode;
    }

    public void setiCode(int iCode) {
        this.iCode = iCode;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }
}
