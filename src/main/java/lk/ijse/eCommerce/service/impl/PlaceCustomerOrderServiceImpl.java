package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.CustomerOrderDTO;
import lk.ijse.eCommerce.dto.CustomerOrderDetailsDTO;
import lk.ijse.eCommerce.dto.CustomerPaymentDTO;
import lk.ijse.eCommerce.dto.PlaceCustomerOrderDTO;
import lk.ijse.eCommerce.entity.*;
import lk.ijse.eCommerce.repository.*;
import lk.ijse.eCommerce.service.PlaceCustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PlaceCustomerOrderServiceImpl implements PlaceCustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerOrderDetailsRepositoy customerOrderDetailsRepositoy;
    @Autowired
    private CustomerPaymentRepository customerPaymentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BatchRepository batchRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean placeCustomerOrder(PlaceCustomerOrderDTO placeCustomerOrderDTO) {

        CustomerOrderDTO customerOrderDTO=placeCustomerOrderDTO.getCustomerOrderDTO();

        Customer customer= new Customer();
        Optional<Customer> op= customerRepository.findById(customerOrderDTO.getCid());
        if(op.isPresent()){
            customer.setCid(op.get().getCid());
            customer.setFirstName(op.get().getFirstName());
            customer.setLastName(op.get().getLastName());
            customer.setNic(op.get().getNic());
            customer.setContact(op.get().getContact());
            customer.setEmail(op.get().getEmail());
            customer.setAddress(op.get().getAddress());
        }

        CustomerOrder customerOrder = new CustomerOrder(customerOrderDTO.getCoid(),customerOrderDTO.getDate(),customer);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        boolean result=customerOrderRepository.save(customerOrder)!=null;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<CustomerOrderDetailsDTO> orderDetailsList = placeCustomerOrderDTO.getCustomerOrderDetails();

        if(result){

            CustomerPaymentDTO customerPaymentDTO= placeCustomerOrderDTO.getCustomerPaymentDTO();
            CustomerPayment customerPayment= new CustomerPayment(customerPaymentDTO.getCpid(),customerPaymentDTO.getAmount(),customerPaymentDTO.getPaymentType(),customerPaymentDTO.getPaymentDetails(),customerPaymentDTO.getDate(),customerOrder);

            boolean res=customerPaymentRepository.save(customerPayment)!=null;

            if(res){

                for (CustomerOrderDetailsDTO orderDetailsDTO : orderDetailsList){

                    Optional<Item> opItem=itemRepository.findById(orderDetailsDTO.getiCode());
                    Item item= new Item();

                    if (opItem.isPresent()){

                        item.setIcode(opItem.get().getIcode());
                        item.setModel(opItem.get().getModel());
                        item.setCategory(opItem.get().getCategory());
                        item.setBrand(opItem.get().getBrand());

                    }

                    Optional<Batch> opBatch=batchRepository.findById(orderDetailsDTO.getBatchId());
                    Batch batch= new Batch();

                    if (opBatch.isPresent()){

                        batch.setBatchId(opBatch.get().getBatchId());
                        batch.setBuyingPrice(opBatch.get().getBuyingPrice());
                        batch.setUnitPrice(opBatch.get().getUnitPrice());
                        batch.setQtyOnHand(opBatch.get().getQtyOnHand());
                        batch.setDate(opBatch.get().getDate());
                        batch.setGrn(opBatch.get().getGrn());
                        batch.setItem(opBatch.get().getItem());

                    }

                    CustomerOrderDetails customerOrderDetails = new CustomerOrderDetails();
                    customerOrderDetails.setOrderQty(orderDetailsDTO.getOrderQty());
                    customerOrderDetails.setUnitPrice(orderDetailsDTO.getUnitPrice());
                    customerOrderDetails.setItem(item);
                    customerOrderDetails.setCustomerOrder(customerOrder);
                    customerOrderDetails.setBatch(batch);
                    customerOrderDetails.setCustomerOrderDetails_pk(new CustomerOrderDetails_PK(customerOrder.getCoid(),item.getIcode(),batch.getBatchId()));

                    customerOrderDetailsRepositoy.save(customerOrderDetails);


                }
                return true;


            }else {
                return false;
            }

        }else {
            return false;
        }

    }
}
