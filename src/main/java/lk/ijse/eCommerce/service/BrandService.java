package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.BrandDTO;

import java.util.List;

public interface BrandService {

    public boolean addBrand(BrandDTO brandDTO);

    public boolean removeBrand(int id);

    public boolean updateBrand(BrandDTO brandDTO);

    public List<BrandDTO> getAllBrands();

    public BrandDTO getBrand(int id);

}
