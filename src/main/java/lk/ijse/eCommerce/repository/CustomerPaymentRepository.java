package lk.ijse.eCommerce.repository;


import lk.ijse.eCommerce.entity.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Integer> {
}
