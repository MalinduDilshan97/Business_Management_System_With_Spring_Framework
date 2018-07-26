package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    public boolean addSupplier(SupplierDTO supplierDTO);

    public boolean removeSupplier(int id);

    public boolean updateSupplier(SupplierDTO supplierDTO);

    public List<SupplierDTO> getAllSuppliers();

    public SupplierDTO getSupplier(int id);

}
