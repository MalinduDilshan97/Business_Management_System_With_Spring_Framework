package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.CustomerDTO;
import lk.ijse.eCommerce.entity.Customer;
import lk.ijse.eCommerce.repository.CustomerRepository;
import lk.ijse.eCommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addCustomer(CustomerDTO customerDTO) {
        Customer customer= new Customer(customerDTO.getCid(),customerDTO.getFirstName(),customerDTO.getLastName(),customerDTO.getNic(),customerDTO.getContact(),customerDTO.getEmail(),customerDTO.getAddress());
        customerRepository.save(customer);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeCustomer(int cid) {
        customerRepository.deleteById(cid);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateCustomer(CustomerDTO customerDTO) {
        Customer customer= new Customer(customerDTO.getCid(),customerDTO.getFirstName(),customerDTO.getLastName(),customerDTO.getNic(),customerDTO.getContact(),customerDTO.getEmail(),customerDTO.getAddress());
        return customerRepository.save(customer)!=null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

            List<Customer> customers = customerRepository.findAll();

            List<CustomerDTO> alCustomers=new ArrayList<>();

            for(Customer customer: customers){
                CustomerDTO customerDTO= new CustomerDTO(customer.getCid(),customer.getFirstName(),customer.getLastName(),customer.getNic(),customer.getContact(),customer.getEmail(),customer.getAddress());
                alCustomers.add(customerDTO);
            }

            return alCustomers;

    }

    @Override
    public CustomerDTO getCustomer(int cid) {
        Optional<Customer> customer= customerRepository.findById(cid);
        CustomerDTO customerDTO= new CustomerDTO(customer.get().getCid(),customer.get().getFirstName(),customer.get().getLastName(),customer.get().getNic(),customer.get().getContact(),customer.get().getEmail(),customer.get().getAddress());
        return customerDTO;
    }
}
