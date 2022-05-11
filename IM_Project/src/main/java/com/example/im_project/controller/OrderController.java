package com.example.im_project.controller;

import com.example.im_project.controller.form.OrderForm;
import com.example.im_project.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final InventoryService inventoryService;

    @GetMapping("/orders/{id}")
    public String createForm(@PathVariable("id") Long id, Model model) {

        OrderForm orderForm = inventoryService.createOrder(id);

        model.addAttribute("orderForm", orderForm);

        return "order/orderForm";
    }

    @PostMapping("/orders/{id}")
    public String addOrder(@PathVariable("id") Long id, @ModelAttribute("orderForm") OrderForm form, BindingResult result, HttpServletRequest request) {
        int checkCount = inventoryService.minCount(id, form);

        if (checkCount == 0) {
            result.rejectValue("minusCount", null, "주문수량보다 보유 수량이 부족합니다.");
            return "redirect:" + request.getHeader("Referer");
        }

        return "redirect:/item/findAll";
    }
}
