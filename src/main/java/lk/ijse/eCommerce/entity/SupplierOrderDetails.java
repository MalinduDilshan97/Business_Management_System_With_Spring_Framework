package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class SupplierOrderDetails {

    private int qty;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "soid",referencedColumnName = "soid",insertable = false, updatable = false))
    private SupplierOrder supplierOrder;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "iCode",referencedColumnName = "iCode",insertable = false,updatable = false))
    private Item item;
    @EmbeddedId
    private SupplierOrderDetails_PK supplierOrderDetails_pk;

    public SupplierOrderDetails() {
    }

    public SupplierOrderDetails(int soid,int icode,int qty, SupplierOrder supplierOrder, Item item) {
        this.qty = qty;
        this.supplierOrder = supplierOrder;
        this.item = item;
        this.supplierOrderDetails_pk = new SupplierOrderDetails_PK(soid,icode);
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SupplierOrderDetails_PK getSupplierOrderDetails_pk() {
        return supplierOrderDetails_pk;
    }

    public void setSupplierOrderDetails_pk(SupplierOrderDetails_PK supplierOrderDetails_pk) {
        this.supplierOrderDetails_pk = supplierOrderDetails_pk;
    }
}
