package inventory.im_project.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
public class MemberTest {
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("saveMember")
    void saveMember() throws Exception {
        Member member = new Member("inhatcName", "inhatcId", "inhatcPW");
        em.persist(member);

        Address address = new Address("인천", "미추홀구1234", "12345");
        address.setMember(member);
        em.persist(address);

    }
}