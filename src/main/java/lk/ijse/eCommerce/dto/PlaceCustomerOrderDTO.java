package lk.ijse.eCommerce.dto;

import java.util.List;

public class PlaceCustomerOrderDTO {

    private CustomerOrderDTO customerOrderDTO;
    private List<CustomerOrderDetailsDTO> customerOrderDetails;
    private CustomerPaymentDTO customerPaymentDTO;

    public PlaceCustomerOrderDTO() {
    }

    public PlaceCustomerOrderDTO(CustomerOrderDTO customerOrderDTO, List<CustomerOrderDetailsDTO> customerOrderDetails, CustomerPaymentDTO customerPaymentDTO) {
        this.customerOrderDTO = customerOrderDTO;
        this.customerOrderDetails = customerOrderDetails;
        this.customerPaymentDTO = customerPaymentDTO;
    }

    public CustomerOrderDTO getCustomerOrderDTO() {
        return customerOrderDTO;
    }

    public void setCustomerOrderDTO(CustomerOrderDTO customerOrderDTO) {
        this.customerOrderDTO = customerOrderDTO;
    }

    public List<CustomerOrderDetailsDTO> getCustomerOrderDetails() {
        return customerOrderDetails;
    }

    public void setCustomerOrderDetails(List<CustomerOrderDetailsDTO> customerOrderDetails) {
        this.customerOrderDetails = customerOrderDetails;
    }

    public CustomerPaymentDTO getCustomerPaymentDTO() {
        return customerPaymentDTO;
    }

    public void setCustomerPaymentDTO(CustomerPaymentDTO customerPaymentDTO) {
        this.customerPaymentDTO = customerPaymentDTO;
    }
}
