package lk.ijse.eCommerce.dto;



public class BatchDTO {

    private int batchId;
    private double buyingPrice;
    private double unitPrice;
    private int qtyOnHand;
    private String date;
    private ItemDTO itemDTO;
    private GRNDTO grndto;

    public BatchDTO() {
    }

    public BatchDTO(double buyingPrice, double unitPrice, int qtyOnHand, String date, ItemDTO itemDTO, GRNDTO grndto) {
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.date = date;
        this.itemDTO = itemDTO;
        this.grndto = grndto;
    }

    public BatchDTO(int batchId, double buyingPrice, double unitPrice, int qtyOnHand, String date, ItemDTO itemDTO, GRNDTO grndto) {
        this.batchId = batchId;
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.date = date;
        this.itemDTO = itemDTO;
        this.grndto = grndto;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    public GRNDTO getGrndto() {
        return grndto;
    }

    public void setGrndto(GRNDTO grndto) {
        this.grndto = grndto;
    }
}
