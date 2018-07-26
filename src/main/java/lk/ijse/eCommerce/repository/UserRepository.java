package lk.ijse.eCommerce.repository;

import lk.ijse.eCommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , String> {

}
