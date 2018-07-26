package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.*;
import lk.ijse.eCommerce.entity.*;
import lk.ijse.eCommerce.repository.BatchRepository;
import lk.ijse.eCommerce.repository.SupplierOrderRepository;
import lk.ijse.eCommerce.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private SupplierOrderRepository supplierOrderRepository;

    @Override
    public boolean addBatch(BatchDTO batchDTO) {

        Brand brand= new Brand(batchDTO.getItemDTO().getBrandDTO().getBrandId(),batchDTO.getItemDTO().getBrandDTO().getBrandName());
        Category category= new Category(batchDTO.getItemDTO().getCategoryDTO().getCategoryId(),batchDTO.getItemDTO().getCategoryDTO().getCategoryName());
        Item item= new Item(batchDTO.getItemDTO().getIcode(),batchDTO.getItemDTO().getModel(),category,brand);

        Optional<SupplierOrder> op=supplierOrderRepository.findById(batchDTO.getGrndto().getSoid());
        Supplier supplier=op.get().getSupplier();

        SupplierOrder supplierOrder = new SupplierOrder(op.get().getSoid(),op.get().getDate(),supplier);

        GRNDTO grndto= batchDTO.getGrndto();
        GRN grn= new GRN(grndto.getGrnId(),grndto.getDate(),supplierOrder);

        Batch batch=new Batch(batchDTO.getBatchId(),batchDTO.getBuyingPrice(),batchDTO.getUnitPrice(),batchDTO.getQtyOnHand(),batchDTO.getDate(),item,grn);

        batchRepository.save(batch);
        return true;
    }

    @Override
    public boolean removeBatch(int id) {
        batchRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateBatch(BatchDTO batchDTO) {

        Brand brand= new Brand(batchDTO.getItemDTO().getBrandDTO().getBrandId(),batchDTO.getItemDTO().getBrandDTO().getBrandName());
        Category category= new Category(batchDTO.getItemDTO().getCategoryDTO().getCategoryId(),batchDTO.getItemDTO().getCategoryDTO().getCategoryName());
        Item item= new Item(batchDTO.getItemDTO().getIcode(),batchDTO.getItemDTO().getModel(),category,brand);

        Optional<SupplierOrder> op=supplierOrderRepository.findById(batchDTO.getGrndto().getSoid());
        Supplier supplier=op.get().getSupplier();

        SupplierOrder supplierOrder = new SupplierOrder(op.get().getSoid(),op.get().getDate(),supplier);

        GRNDTO grndto= batchDTO.getGrndto();
        GRN grn= new GRN(grndto.getGrnId(),grndto.getDate(),supplierOrder);

        Batch batch=new Batch(batchDTO.getBatchId(),batchDTO.getBuyingPrice(),batchDTO.getUnitPrice(),batchDTO.getQtyOnHand(),batchDTO.getDate(),item,grn);

        return batchRepository.save(batch)!=null;
    }

    @Override
    public List<BatchDTO> getAllBatches() {

        List<Batch> batches = batchRepository.findAll();

        List<BatchDTO> alBatches=new ArrayList<>();

        for(Batch batch: batches){

            Category category= batch.getItem().getCategory();
            CategoryDTO categoryDTO = new CategoryDTO(category.getCategoryId(),category.getCategoryName());

            Brand brand= batch.getItem().getBrand();
            BrandDTO brandDTO = new BrandDTO(brand.getBrandId(),brand.getBrandName());

            Item item= batch.getItem();
            ItemDTO itemDTO=new ItemDTO(item.getIcode(),item.getModel(),categoryDTO,brandDTO);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Supplier supplier= batch.getGrn().getSupplierOrder().getSupplier();
            SupplierDTO supplierDTO = new SupplierDTO(supplier.getSid(),supplier.getName(),supplier.getContact(),supplier.getEmail(),supplier.getAddress());

            SupplierOrder supplierOrder =batch.getGrn().getSupplierOrder();
            SupplierOrderDTO supplierOrderDTO = new SupplierOrderDTO(supplierOrder.getSoid(),supplierOrder.getDate(),supplier.getSid());

            GRN grn= batch.getGrn();
            GRNDTO grndto= new GRNDTO(grn.getGrnId(),grn.getDate(),supplierOrderDTO.getSoid());


            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            BatchDTO batchDTO = new BatchDTO(batch.getBatchId(),batch.getBuyingPrice(),batch.getUnitPrice(),batch.getQtyOnHand(),batch.getDate(),itemDTO,grndto);


            alBatches.add(batchDTO);
        }

        return alBatches;
    }

    @Override
    public BatchDTO getBatch(int id) {

        Optional<Batch> batch1=batchRepository.findById(id);
        Batch batch=batch1.get();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Category category= batch.getItem().getCategory();
        CategoryDTO categoryDTO = new CategoryDTO(category.getCategoryId(),category.getCategoryName());

        Brand brand= batch.getItem().getBrand();
        BrandDTO brandDTO = new BrandDTO(brand.getBrandId(),brand.getBrandName());

        Item item= batch.getItem();
        ItemDTO itemDTO=new ItemDTO(item.getIcode(),item.getModel(),categoryDTO,brandDTO);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Supplier supplier= batch.getGrn().getSupplierOrder().getSupplier();
        SupplierDTO supplierDTO = new SupplierDTO(supplier.getSid(),supplier.getName(),supplier.getContact(),supplier.getEmail(),supplier.getAddress());

        SupplierOrder supplierOrder =batch.getGrn().getSupplierOrder();
        SupplierOrderDTO supplierOrderDTO = new SupplierOrderDTO(supplierOrder.getSoid(),supplierOrder.getDate(),supplier.getSid());

        GRN grn= batch.getGrn();
        GRNDTO grndto= new GRNDTO(grn.getGrnId(),grn.getDate(),supplierOrderDTO.getSoid());


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        BatchDTO batchDTO = new BatchDTO(batch.getBatchId(),batch.getBuyingPrice(),batch.getUnitPrice(),batch.getQtyOnHand(),batch.getDate(),itemDTO,grndto);

        return batchDTO;

    }
}
