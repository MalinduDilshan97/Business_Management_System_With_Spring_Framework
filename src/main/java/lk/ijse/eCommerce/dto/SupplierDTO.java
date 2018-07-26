package lk.ijse.eCommerce.dto;

public class SupplierDTO {

    private int sid;
    private String name;
    private String contact;
    private String email;
    private String address;

    public SupplierDTO() {
    }

    public SupplierDTO(String name, String contact, String email, String address) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public SupplierDTO(int sid, String name, String contact, String email, String address) {
        this.sid = sid;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
