package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.PlaceSupplierOrderDTO;
import lk.ijse.eCommerce.dto.SupplierOrderDTO;
import lk.ijse.eCommerce.dto.SupplierOrderDetailsDTO;
import lk.ijse.eCommerce.entity.*;
import lk.ijse.eCommerce.repository.ItemRepository;
import lk.ijse.eCommerce.repository.SupplierOrderDetailsRepository;
import lk.ijse.eCommerce.repository.SupplierOrderRepository;
import lk.ijse.eCommerce.repository.SupplierRepository;
import lk.ijse.eCommerce.service.PlaceSupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PlaceSupplierOrderServiceImpl implements PlaceSupplierOrderService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierOrderRepository supplierOrderRepository;
    @Autowired
    private SupplierOrderDetailsRepository supplierOrderDetailsRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean placeSupplierOrder(PlaceSupplierOrderDTO placeSupplierOrderDTO) {

        SupplierOrderDTO supplierOrderDTO = placeSupplierOrderDTO.getSupplierOrderDTO();
        Optional<Supplier>op=supplierRepository.findById(supplierOrderDTO.getSid());
        Supplier supplier= new Supplier();

        if (op.isPresent()){
            supplier.setSid(op.get().getSid());
            supplier.setName(op.get().getName());
            supplier.setContact(op.get().getContact());
            supplier.setEmail(op.get().getEmail());
            supplier.setAddress(op.get().getAddress());
        }

        SupplierOrder supplierOrder= new SupplierOrder(supplierOrderDTO.getSoid(),supplierOrderDTO.getDate(),supplier);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        boolean results=supplierOrderRepository.save(supplierOrder)!=null;

        if (results){

            List<SupplierOrderDetailsDTO> detailsDTOList=placeSupplierOrderDTO.getSupplierOrderDetails();

            for (SupplierOrderDetailsDTO details : detailsDTOList){

                Optional<Item> opItem=itemRepository.findById(details.getIcode());
                Item item= new Item();

                if (opItem.isPresent()){
                    item.setIcode(opItem.get().getIcode());
                    item.setModel(opItem.get().getModel());
                    item.setCategory(opItem.get().getCategory());
                    item.setBrand(opItem.get().getBrand());
                }

                SupplierOrderDetails supplierOrderDetails=new SupplierOrderDetails();
                supplierOrderDetails.setQty(details.getQty());
                supplierOrderDetails.setItem(item);
                supplierOrderDetails.setSupplierOrder(supplierOrder);
                supplierOrderDetails.setSupplierOrderDetails_pk(new SupplierOrderDetails_PK(supplierOrder.getSoid(),item.getIcode()));

                supplierOrderDetailsRepository.save(supplierOrderDetails);

            }
            return true;

        }else {
            return false;
        }


    }
}
