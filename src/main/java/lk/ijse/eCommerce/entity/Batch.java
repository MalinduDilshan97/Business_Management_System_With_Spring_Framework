package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batchId;
    private double buyingPrice;
    private double unitPrice;
    private int qtyOnHand;
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iCode")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grnId")
    private GRN grn;

    public Batch() {
    }

    public Batch(double buyingPrice, double unitPrice, int qtyOnHand, String date, Item item, GRN grn) {
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.date = date;
        this.item = item;
        this.grn = grn;
    }

    public Batch(int batchId, double buyingPrice, double unitPrice, int qtyOnHand, String date, Item item, GRN grn) {
        this.batchId = batchId;
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.date = date;
        this.item = item;
        this.grn = grn;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public GRN getGrn() {
        return grn;
    }

    public void setGrn(GRN grn) {
        this.grn = grn;
    }
}
