package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    public boolean addItem(ItemDTO itemDTO);

    public boolean removeItem(int iCode);

    public boolean updateItem(ItemDTO itemDTO);

    public List<ItemDTO> getAllItems();

    public ItemDTO getItem(int iCode);

}
