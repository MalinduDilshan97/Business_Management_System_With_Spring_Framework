package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.CustomerOrderDTO;

import java.util.List;

public interface CustomerOrderService {

    public boolean addCustomerOrder(CustomerOrderDTO customerOrderDTO);

    public List<CustomerOrderDTO> getAllCustomerOrders();



}
