package lk.ijse.eCommerce.dto;

import java.util.List;

public class PlaceSupplierOrderDTO {

    private SupplierOrderDTO supplierOrderDTO;
    private List<SupplierOrderDetailsDTO> supplierOrderDetails;


    public PlaceSupplierOrderDTO() {
    }

    public PlaceSupplierOrderDTO(SupplierOrderDTO supplierOrderDTO, List<SupplierOrderDetailsDTO> supplierOrderDetails) {
        this.supplierOrderDTO = supplierOrderDTO;
        this.supplierOrderDetails = supplierOrderDetails;
    }

    public SupplierOrderDTO getSupplierOrderDTO() {
        return supplierOrderDTO;
    }

    public void setSupplierOrderDTO(SupplierOrderDTO supplierOrderDTO) {
        this.supplierOrderDTO = supplierOrderDTO;
    }

    public List<SupplierOrderDetailsDTO> getSupplierOrderDetails() {
        return supplierOrderDetails;
    }

    public void setSupplierOrderDetails(List<SupplierOrderDetailsDTO> supplierOrderDetails) {
        this.supplierOrderDetails = supplierOrderDetails;
    }

}
