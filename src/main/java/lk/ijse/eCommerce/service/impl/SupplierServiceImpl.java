package lk.ijse.eCommerce.service.impl;


import lk.ijse.eCommerce.dto.SupplierDTO;
import lk.ijse.eCommerce.entity.Supplier;
import lk.ijse.eCommerce.repository.SupplierRepository;
import lk.ijse.eCommerce.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addSupplier(SupplierDTO supplierDTO) {
        Supplier  supplier= new Supplier(supplierDTO.getSid(),supplierDTO.getName(),supplierDTO.getContact(),supplierDTO.getEmail(),supplierDTO.getAddress());
        supplierRepository.save(supplier);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeSupplier(int id) {
        supplierRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateSupplier(SupplierDTO supplierDTO) {
        Supplier  supplier= new Supplier(supplierDTO.getSid(),supplierDTO.getName(),supplierDTO.getContact(),supplierDTO.getEmail(),supplierDTO.getAddress());
        supplierRepository.save(supplier);
        return true;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();

        List<SupplierDTO> alSuppliers=new ArrayList<>();

        for(Supplier supplier: suppliers){
            SupplierDTO supplierDTO= new SupplierDTO(supplier.getSid(),supplier.getName(),supplier.getContact(),supplier.getEmail(),supplier.getAddress());
            alSuppliers.add(supplierDTO);
        }

        return alSuppliers;
    }

    @Override
    public SupplierDTO getSupplier(int id) {
        Optional<Supplier> supplier=supplierRepository.findById(id);
        SupplierDTO supplierDTO= new SupplierDTO(supplier.get().getSid(),supplier.get().getName(),supplier.get().getContact(),supplier.get().getEmail(),supplier.get().getAddress());
        return supplierDTO;
    }
}
