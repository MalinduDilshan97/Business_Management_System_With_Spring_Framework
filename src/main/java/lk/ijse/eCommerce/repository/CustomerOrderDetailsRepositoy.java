package lk.ijse.eCommerce.repository;


import lk.ijse.eCommerce.entity.CustomerOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderDetailsRepositoy extends JpaRepository<CustomerOrderDetails,Integer> {
}
