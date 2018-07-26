package lk.ijse.eCommerce.dto;

public class GRNDetailsDTO {


    private double buyingPrice;
    private double sellingPrice;
    private int qty;
    private int iCode;

    public GRNDetailsDTO() {
    }

    public GRNDetailsDTO(double buyingPrice, double sellingPrice, int qty, int iCode) {
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
        this.iCode = iCode;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getiCode() {
        return iCode;
    }

    public void setiCode(int iCode) {
        this.iCode = iCode;
    }
}
