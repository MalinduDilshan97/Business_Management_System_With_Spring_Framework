package lk.ijse.eCommerce.entity;

import javax.persistence.*;


@Entity
public class CustomerOrderDetails {


    private double unitPrice;
    private int orderQty;
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumns(@JoinColumn (name = "coid", referencedColumnName = "coid", insertable = false,updatable = false))
    private CustomerOrder customerOrder;
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumns(@JoinColumn(name = "iCode" , referencedColumnName = "iCode",insertable = false,updatable = false))
    private Item item;
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumns(@JoinColumn(name = "batchId",referencedColumnName = "batchId",insertable = false,updatable = false))
    private Batch batch;
    @EmbeddedId
    private CustomerOrderDetails_PK customerOrderDetails_pk;

    public CustomerOrderDetails() {
    }

    public CustomerOrderDetails(int coid, int iCode, int bathId, double unitPrice, int orderQty, CustomerOrder customerOrder, Item item, Batch batch) {
        this.unitPrice = unitPrice;
        this.orderQty = orderQty;
        this.customerOrder = customerOrder;
        this.item = item;
        this.batch = batch;
        this.customerOrderDetails_pk = new CustomerOrderDetails_PK(coid,iCode,bathId);
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

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public CustomerOrderDetails_PK getCustomerOrderDetails_pk() {
        return customerOrderDetails_pk;
    }

    public void setCustomerOrderDetails_pk(CustomerOrderDetails_PK customerOrderDetails_pk) {
        this.customerOrderDetails_pk = customerOrderDetails_pk;
    }
}
