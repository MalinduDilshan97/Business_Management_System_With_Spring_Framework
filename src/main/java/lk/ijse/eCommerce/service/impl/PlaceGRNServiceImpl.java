package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.GRNDTO;
import lk.ijse.eCommerce.dto.GRNDetailsDTO;
import lk.ijse.eCommerce.dto.PlaceGRNDTO;
import lk.ijse.eCommerce.dto.SupplierPaymentDTO;
import lk.ijse.eCommerce.entity.*;
import lk.ijse.eCommerce.repository.*;
import lk.ijse.eCommerce.service.PlaceGRNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PlaceGRNServiceImpl implements PlaceGRNService {

    @Autowired
    private SupplierOrderRepository supplierOrderRepository;
    @Autowired
    private GRNRepository grnRepository;
    @Autowired
    private GRNDetailsRepository grnDetailsRepository;
    @Autowired
    private SupplierPaymentRepository supplierPaymentRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean PlaceGRN(PlaceGRNDTO placeGRNDTO) {

        GRNDTO grndto= placeGRNDTO.getGrndto();
        SupplierOrder supplierOrder = new SupplierOrder();
        Optional<SupplierOrder> op=supplierOrderRepository.findById(grndto.getSoid());

        if (op.isPresent()){
            supplierOrder.setSoid(op.get().getSoid());
            supplierOrder.setDate(op.get().getDate());
            supplierOrder.setSupplier(op.get().getSupplier());

        }

        GRN grn= new GRN(grndto.getGrnId(),grndto.getDate(),supplierOrder);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        boolean results=grnRepository.save(grn)!=null;

        if (results){

            SupplierPaymentDTO supplierPaymentDTO = placeGRNDTO.getSupplierPaymentDTO();
            SupplierPayment supplierPayment = new SupplierPayment(supplierPaymentDTO.getSpid(),supplierPaymentDTO.getAmount(),supplierPaymentDTO.getDate(),supplierPaymentDTO.getPaymentType(),supplierPaymentDTO.getPaymentDetails(),grn);

            boolean res= supplierPaymentRepository.save(supplierPayment)!=null;

            if (res){

                List<GRNDetailsDTO> grnDetailsDTOList=placeGRNDTO.getGrnDetails();

                for (GRNDetailsDTO grnDetailsDTO : grnDetailsDTOList){

                    Optional<Item> opItem=itemRepository.findById(grnDetailsDTO.getiCode());
                    Item item= new Item();

                    if (opItem.isPresent()){

                        item.setIcode(opItem.get().getIcode());
                        item.setModel(opItem.get().getModel());
                        item.setCategory(opItem.get().getCategory());
                        item.setBrand(opItem.get().getBrand());
                    }

                    GRNDetails grnDetails= new GRNDetails();
                    grnDetails.setBuyingPrice(grnDetailsDTO.getBuyingPrice());
                    grnDetails.setSellingPrice(grnDetailsDTO.getSellingPrice());
                    grnDetails.setQty(grnDetailsDTO.getQty());
                    grnDetails.setGrn(grn);
                    grnDetails.setItem(item);
                    grnDetails.setGrnDetails_pk(new GRNDetails_PK(grn.getGrnId(),item.getIcode()));

                    grnDetailsRepository.save(grnDetails);

                }
                return true;

            }else {
                return false;
            }

        }else {
            return false;
        }

    }
}
