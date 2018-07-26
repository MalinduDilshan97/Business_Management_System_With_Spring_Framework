package lk.ijse.eCommerce.dto;

public class ItemDTO {

    private int icode;
    private String model;
    private CategoryDTO categoryDTO;
    private BrandDTO brandDTO;

    public ItemDTO() {
    }

    public ItemDTO(String model, CategoryDTO categoryDTO, BrandDTO brandDTO) {
        this.model = model;
        this.categoryDTO = categoryDTO;
        this.brandDTO = brandDTO;
    }

    public ItemDTO(int icode, String model, CategoryDTO categoryDTO, BrandDTO brandDTO) {
        this.icode = icode;
        this.model = model;
        this.categoryDTO = categoryDTO;
        this.brandDTO = brandDTO;
    }

    public int getIcode() {
        return icode;
    }

    public void setIcode(int icode) {
        this.icode = icode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public BrandDTO getBrandDTO() {
        return brandDTO;
    }

    public void setBrandDTO(BrandDTO brandDTO) {
        this.brandDTO = brandDTO;
    }
}
