package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.BrandDTO;
import lk.ijse.eCommerce.entity.Brand;
import lk.ijse.eCommerce.repository.BrandRepository;
import lk.ijse.eCommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addBrand(BrandDTO brandDTO) {
        Brand brand= new Brand(brandDTO.getBrandId(),brandDTO.getBrandName());
        brandRepository.save(brand);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeBrand(int id) {
        brandRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateBrand(BrandDTO brandDTO) {
        Brand brand= new Brand(brandDTO.getBrandId(),brandDTO.getBrandName());
        brandRepository.save(brand);
        return true;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();

        List<BrandDTO> alBrands=new ArrayList<>();

        for(Brand brand: brands){
            BrandDTO brandDTO= new BrandDTO(brand.getBrandId(),brand.getBrandName());
            alBrands.add(brandDTO);
        }

        return alBrands;
    }

    @Override
    public BrandDTO getBrand(int id) {
        Optional<Brand> brand= brandRepository.findById(id);
        BrandDTO brandDTO= new BrandDTO(brand.get().getBrandId(),brand.get().getBrandName());
        return brandDTO;
    }
}
