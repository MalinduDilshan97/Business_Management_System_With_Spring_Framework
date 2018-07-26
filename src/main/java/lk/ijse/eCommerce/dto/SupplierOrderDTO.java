package lk.ijse.eCommerce.dto;



public class SupplierOrderDTO {

    private int soid;
    private String date;
    private int sid;

    public SupplierOrderDTO() {
    }

    public SupplierOrderDTO(String date, int sid) {
        this.date = date;
        this.sid = sid;
    }

    public SupplierOrderDTO(int soid, String date, int sid) {
        this.soid = soid;
        this.date = date;
        this.sid = sid;
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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
