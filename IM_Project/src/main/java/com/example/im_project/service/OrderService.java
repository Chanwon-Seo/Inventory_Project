package com.example.im_project.service;

import com.example.im_project.controller.form.OrderForm;
import com.example.im_project.domain.Inventory;
import com.example.im_project.repository.InventoryRepository;
import com.example.im_project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class orderService {

    private final InventoryRepository inventoryRepository;
    private final OrderRepository orderRepository;

    public OrderForm selectItem(Long id) {
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        OrderForm orderForm = new OrderForm();

        orderForm.setId(inventory.getId());
        orderForm.setName(inventory.getName());
        orderForm.setAddCount(0);

        return orderForm;
    }
}
