package lk.ijse.eCommerce.dto;

public class SupplierOrderDetailsDTO {

    private int qty;
    private int soid;
    private int icode;

    public SupplierOrderDetailsDTO() {
    }

    public SupplierOrderDetailsDTO(int qty, int soid, int icode) {
        this.qty = qty;
        this.soid = soid;
        this.icode = icode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public int getIcode() {
        return icode;
    }

    public void setIcode(int icode) {
        this.icode = icode;
    }
}
