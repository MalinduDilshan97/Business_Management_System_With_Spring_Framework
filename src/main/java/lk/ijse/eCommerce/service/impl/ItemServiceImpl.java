package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.BrandDTO;
import lk.ijse.eCommerce.dto.CategoryDTO;
import lk.ijse.eCommerce.dto.ItemDTO;
import lk.ijse.eCommerce.entity.Brand;
import lk.ijse.eCommerce.entity.Category;
import lk.ijse.eCommerce.entity.Item;
import lk.ijse.eCommerce.repository.ItemRepository;
import lk.ijse.eCommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addItem(ItemDTO itemDTO) {
        Category category= new Category(itemDTO.getCategoryDTO().getCategoryId(),itemDTO.getCategoryDTO().getCategoryName());
        Brand brand= new Brand(itemDTO.getBrandDTO().getBrandId(),itemDTO.getBrandDTO().getBrandName());
        Item item=new Item(itemDTO.getIcode(),itemDTO.getModel(),category,brand);
        itemRepository.save(item);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeItem(int iCode) {
        itemRepository.deleteById(iCode);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateItem(ItemDTO itemDTO) {
        Category category= new Category(itemDTO.getCategoryDTO().getCategoryId(),itemDTO.getCategoryDTO().getCategoryName());
        Brand brand= new Brand(itemDTO.getBrandDTO().getBrandId(),itemDTO.getBrandDTO().getBrandName());
        Item item=new Item(itemDTO.getIcode(),itemDTO.getModel(),category,brand);
        return itemRepository.save(item)!=null;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();

        List<ItemDTO> alItems=new ArrayList<>();

        for(Item item: items){
            CategoryDTO categoryDTO= new CategoryDTO(item.getCategory().getCategoryId(),item.getCategory().getCategoryName());
            BrandDTO brandDTO = new BrandDTO(item.getBrand().getBrandId(),item.getBrand().getBrandName());
            ItemDTO itemDTO= new ItemDTO(item.getIcode(),item.getModel(),categoryDTO,brandDTO);
            alItems.add(itemDTO);
        }

        return alItems;

    }

    @Override
    public ItemDTO getItem(int iCode) {
        Optional<Item> item= itemRepository.findById(iCode);
        CategoryDTO categoryDTO= new CategoryDTO(item.get().getCategory().getCategoryId(),item.get().getCategory().getCategoryName());
        BrandDTO brandDTO = new BrandDTO(item.get().getBrand().getBrandId(),item.get().getBrand().getBrandName());
        ItemDTO itemDTO= new ItemDTO(item.get().getIcode(),item.get().getModel(),categoryDTO,brandDTO);
        return itemDTO;
    }
}
