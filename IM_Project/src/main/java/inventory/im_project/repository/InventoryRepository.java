package inventory.im_project.repository;

import inventory.im_project.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
