package lk.ijse.eCommerce.service.impl;


import lk.ijse.eCommerce.dto.CategoryDTO;
import lk.ijse.eCommerce.entity.Category;
import lk.ijse.eCommerce.repository.CategoryRepository;
import lk.ijse.eCommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addCategory(CategoryDTO categoryDTO) {
        Category category= new Category(categoryDTO.getCategoryId(),categoryDTO.getCategoryName());
        categoryRepository.save(category);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeCategory(int id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateCategory(CategoryDTO categoryDTO) {
        Category category= new Category(categoryDTO.getCategoryId(),categoryDTO.getCategoryName());
        categoryRepository.save(category);
        return true;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDTO> alCategories=new ArrayList<>();

        for(Category category: categories){
            CategoryDTO categoryDTO= new CategoryDTO(category.getCategoryId(),category.getCategoryName());
            alCategories.add(categoryDTO);
        }

        return alCategories;
    }

    @Override
    public CategoryDTO getCategory(int id) {
        Optional<Category> category=categoryRepository.findById(id);
        CategoryDTO categoryDTO= new CategoryDTO(category.get().getCategoryId(),category.get().getCategoryName());
        return categoryDTO;
    }
}
