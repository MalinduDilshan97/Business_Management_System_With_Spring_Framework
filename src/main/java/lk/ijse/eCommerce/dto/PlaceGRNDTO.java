package lk.ijse.eCommerce.dto;

import java.util.List;

public class PlaceGRNDTO {

    private GRNDTO grndto;
    private List<GRNDetailsDTO> grnDetails;
    private SupplierPaymentDTO supplierPaymentDTO;

    public PlaceGRNDTO() {
    }

    public PlaceGRNDTO(GRNDTO grndto, List<GRNDetailsDTO> grnDetails, SupplierPaymentDTO supplierPaymentDTO) {
        this.grndto = grndto;
        this.grnDetails = grnDetails;
        this.supplierPaymentDTO = supplierPaymentDTO;
    }

    public GRNDTO getGrndto() {
        return grndto;
    }

    public void setGrndto(GRNDTO grndto) {
        this.grndto = grndto;
    }

    public List<GRNDetailsDTO> getGrnDetails() {
        return grnDetails;
    }

    public void setGrnDetails(List<GRNDetailsDTO> grnDetails) {
        this.grnDetails = grnDetails;
    }

    public SupplierPaymentDTO getSupplierPaymentDTO() {
        return supplierPaymentDTO;
    }

    public void setSupplierPaymentDTO(SupplierPaymentDTO supplierPaymentDTO) {
        this.supplierPaymentDTO = supplierPaymentDTO;
    }
}
