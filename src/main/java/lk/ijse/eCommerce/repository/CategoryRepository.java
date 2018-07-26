package lk.ijse.eCommerce.repository;

import lk.ijse.eCommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
