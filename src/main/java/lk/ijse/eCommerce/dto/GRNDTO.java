package lk.ijse.eCommerce.dto;

public class GRNDTO {

    private int grnId;
    private String date;
    private int soid;

    public GRNDTO() {
    }

    public GRNDTO(String date, int soid) {
        this.date = date;
        this.soid = soid;
    }

    public GRNDTO(int grnId, String date, int soid) {
        this.grnId = grnId;
        this.date = date;
        this.soid = soid;
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

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }
}
