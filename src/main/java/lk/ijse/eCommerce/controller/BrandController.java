package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.BrandDTO;
import lk.ijse.eCommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addBrand(@RequestBody BrandDTO brandDTO){
        return brandService.addBrand(brandDTO);
    }

    @DeleteMapping(value = "{brandId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteBrand(@PathVariable("brandId") int brandId){
          return brandService.removeBrand(brandId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateBrand(@RequestBody BrandDTO brandDTO){
        return brandService.updateBrand(brandDTO);
    }

    @GetMapping(value = "{brandId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public BrandDTO getBrand(@PathVariable("brandId") int brandId){
        return brandService.getBrand(brandId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BrandDTO> getAllBrand(){
        return brandService.getAllBrands();
    }

}
