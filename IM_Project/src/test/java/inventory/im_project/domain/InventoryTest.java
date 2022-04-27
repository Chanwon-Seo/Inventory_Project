package inventory.im_project.domain;

import inventory.im_project.repository.InventoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class InventoryTest {
    @Autowired
    EntityManager em;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    @DisplayName("inventorySave")
    void inventorySave() throws Exception {
        Inventory result = new Inventory("안녕", 100, 1000);
        em.persist(result);

        System.out.println(inventoryRepository.findAll());
    }
}