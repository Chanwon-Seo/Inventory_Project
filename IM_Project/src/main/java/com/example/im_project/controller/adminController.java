package com.example.im_project.controller;

import com.example.im_project.domain.Order;
import com.example.im_project.service.AddressService;
import com.example.im_project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class adminController {
    private final OrderService orderService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/orderList")
    public String adminOrderGET(Model model) {
        List<Order> adminOrderList = orderService.findList();

        model.addAttribute("orderLists", adminOrderList);
        return "admin/adminOrderList";
    }

    @PostMapping("/admin/orderList/{id}")
    public String adminOrderPOST(@PathVariable("id") Long orderId) {
        orderService.findOrderId(orderId);

        return "admin/adminOrderList";
    }

}
