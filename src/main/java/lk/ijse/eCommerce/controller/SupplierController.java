package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.SupplierDTO;
import lk.ijse.eCommerce.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addSuplier(@RequestBody SupplierDTO supplierDTO){
        return supplierService.addSupplier(supplierDTO);
    }

    @DeleteMapping(value = "{sid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteSupplier(@PathVariable("sid") int sid){
        return supplierService.removeSupplier(sid);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateSupplier(@RequestBody SupplierDTO supplierDTO){
        return supplierService.updateSupplier(supplierDTO);
    }

    @GetMapping(value = "{sid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierDTO getSupplier(@PathVariable("sid") int sid){
        return supplierService.getSupplier(sid);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

}
