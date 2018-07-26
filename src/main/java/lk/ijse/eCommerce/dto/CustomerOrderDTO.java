package lk.ijse.eCommerce.dto;

public class CustomerOrderDTO {

    private int coid;
    private String date;
    private int cid;

    public CustomerOrderDTO() {
    }

    public CustomerOrderDTO(String date, int cid) {
        this.date = date;
        this.cid = cid;
    }

    public CustomerOrderDTO(int coid, String date, int cid) {
        this.coid = coid;
        this.date = date;
        this.cid = cid;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
