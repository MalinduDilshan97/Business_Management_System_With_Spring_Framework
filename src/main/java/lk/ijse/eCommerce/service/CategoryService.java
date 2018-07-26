package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public boolean addCategory(CategoryDTO categoryDTO);

    public boolean removeCategory(int id);

    public boolean updateCategory(CategoryDTO categoryDTO);

    public List<CategoryDTO> getAllCategories();

    public CategoryDTO getCategory(int id);

}
