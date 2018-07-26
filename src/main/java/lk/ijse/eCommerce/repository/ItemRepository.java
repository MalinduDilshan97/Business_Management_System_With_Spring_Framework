package lk.ijse.eCommerce.repository;

import lk.ijse.eCommerce.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
