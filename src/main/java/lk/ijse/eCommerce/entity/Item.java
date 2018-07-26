package lk.ijse.eCommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int icode;
    private String model;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brandId")
    private Brand brand;

    public Item() {
    }

    public Item(String model, Category category, Brand brand) {
        this.model = model;
        this.category = category;
        this.brand = brand;
    }

    public Item(int icode, String model, Category category, Brand brand) {
        this.icode = icode;
        this.model = model;
        this.category = category;
        this.brand = brand;
    }

    public int getIcode() {
        return icode;
    }

    public void setIcode(int icode) {
        this.icode = icode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
