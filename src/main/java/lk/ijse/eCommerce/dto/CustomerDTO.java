package lk.ijse.eCommerce.dto;

public class CustomerDTO {

    private int cid;
    private String firstName;
    private String lastName;
    private String nic;
    private String contact;
    private String email;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String firstName, String lastName, String nic, String contact, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public CustomerDTO(int cid, String firstName, String lastName, String nic, String contact, String email, String address) {
        this.cid = cid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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
