package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
public class GRN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grnId;
    private String date;
    @OneToOne
    @JoinColumn(name = "soid")
    private SupplierOrder supplierOrder;

    public GRN() {
    }

    public GRN(String date, SupplierOrder supplierOrder) {
        this.date = date;
        this.supplierOrder = supplierOrder;
    }

    public GRN(int grnId, String date, SupplierOrder supplierOrder) {
        this.grnId = grnId;
        this.date = date;
        this.supplierOrder = supplierOrder;
    }

    public int getGrnId() {
        return grnId;
    }

    public void setGrnId(int grnId) {
        this.grnId = grnId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
    }
}
