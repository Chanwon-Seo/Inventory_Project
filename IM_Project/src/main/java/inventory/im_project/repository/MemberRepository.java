package inventory.im_project.repository;


import inventory.im_project.controller.MemberForm;
import inventory.im_project.controller.MemberLoginForm;
import inventory.im_project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    Optional<Member> findByUserId(String userId);
}
