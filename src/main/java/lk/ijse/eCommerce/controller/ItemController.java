package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.ItemDTO;
import lk.ijse.eCommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addItem(@RequestBody ItemDTO itemDTO){
        return itemService.addItem(itemDTO);
    }

    @DeleteMapping(value = "{iCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteItem(@PathVariable("iCode") int iCode) {
        return itemService.removeItem(iCode);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateItem(@RequestBody ItemDTO itemDTO){
        return itemService.updateItem(itemDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItem(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "{iCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO getItem(@PathVariable("iCode") int iCode){
        return itemService.getItem(iCode);
    }
}
