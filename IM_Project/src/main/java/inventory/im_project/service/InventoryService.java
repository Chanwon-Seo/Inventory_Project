package inventory.im_project.service;

import inventory.im_project.controller.form.InventoryForm;
import inventory.im_project.controller.form.MemberForm;
import inventory.im_project.domain.Address;
import inventory.im_project.domain.Inventory;
import inventory.im_project.domain.Member;
import inventory.im_project.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public Long join(InventoryForm form) {

        validateDuplicateMember(form); //중복 회원 검증

        Inventory inventory = new Inventory(form);

        inventoryRepository.save(inventory);

        return inventory.getId();
    }

    private void validateDuplicateMember(InventoryForm form) {
        List<Inventory> findInventory = inventoryRepository.findByName(form.getName());

        if (!findInventory.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 상품입니다"); //프론트
        }
    }

    public List<Inventory> findInventoryByAll() {
        return inventoryRepository.findAll();
    }
}
