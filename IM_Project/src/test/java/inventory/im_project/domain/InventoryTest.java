package inventory.im_project.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class InventoryTest {
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("inventorySave")
    void inventorySave() throws Exception {
        Inventory asdf = new Inventory("안녕", 100, 1001);
        em.persist(asdf);
    }
}