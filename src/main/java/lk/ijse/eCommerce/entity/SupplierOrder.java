package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
public class SupplierOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int soid;
    private String date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sid")
    private Supplier supplier;

    public SupplierOrder() {
    }

    public SupplierOrder(String date, Supplier supplier) {
        this.date = date;
        this.supplier = supplier;
    }

    public SupplierOrder(int soid, String date, Supplier supplier) {
        this.soid = soid;
        this.date = date;
        this.supplier = supplier;
    }

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
