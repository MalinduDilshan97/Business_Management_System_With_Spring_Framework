package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    public boolean addCustomer(CustomerDTO customerDTO);

    public boolean removeCustomer(int id);

    public boolean updateCustomer(CustomerDTO customerDTO);

    public List<CustomerDTO> getAllCustomers();

    public CustomerDTO getCustomer(int id);

}
