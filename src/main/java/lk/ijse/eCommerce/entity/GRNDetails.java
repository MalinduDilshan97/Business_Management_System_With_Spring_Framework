package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class GRNDetails {

    private double buyingPrice;
    private double sellingPrice;
    private int qty;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "grnId",referencedColumnName = "grnId",insertable =  false,updatable = false))
    private GRN grn;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn ( name = "iCode",referencedColumnName = "iCode",insertable =   false,updatable = false))
    private Item item;
    @EmbeddedId
    private GRNDetails_PK grnDetails_pk;

    public GRNDetails() {
    }

    public GRNDetails(int grnId, int iCode ,double buyingPrice, double sellingPrice, int qty, GRN grn, Item item) {
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
        this.grn = grn;
        this.item = item;
        this.grnDetails_pk = new GRNDetails_PK(grnId,iCode);
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

    public GRN getGrn() {
        return grn;
    }

    public void setGrn(GRN grn) {
        this.grn = grn;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public GRNDetails_PK getGrnDetails_pk() {
        return grnDetails_pk;
    }

    public void setGrnDetails_pk(GRNDetails_PK grnDetails_pk) {
        this.grnDetails_pk = grnDetails_pk;
    }
}
