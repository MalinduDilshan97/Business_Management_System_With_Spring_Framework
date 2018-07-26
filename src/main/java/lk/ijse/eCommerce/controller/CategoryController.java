package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.CategoryDTO;
import lk.ijse.eCommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addCategory(@RequestBody CategoryDTO categoryDTO){
        return  categoryService.addCategory(categoryDTO);
    }

    @DeleteMapping(value = "{categoryId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCategory(@PathVariable("categoryId") int categoryId){
        return categoryService.removeCategory(categoryId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "{categoryId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDTO getCategory(@PathVariable("categoryId") int categoryId){
        return categoryService.getCategory(categoryId);
    }
}
