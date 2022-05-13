package com.example.im_project.controller;

import com.example.im_project.config.auth.PrincipalDetails;
import com.example.im_project.controller.form.OrderForm;
import com.example.im_project.domain.Address;
import com.example.im_project.service.AddressService;
import com.example.im_project.service.orderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final orderService orderService;
    private final AddressService addressService;

    @GetMapping("/order/{id}")
    public String orderGET(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        String session_userId = principalDetails.getUsername();
        OrderForm orderForm = orderService.selectItem(id);
        List<Address> addresses = addressService.findAddress(session_userId);


        model.addAttribute("data", session_userId);
        model.addAttribute("orderForm", orderForm);
        model.addAttribute("addresses", addresses);

        return "order/orderForm";
    }

//    @PostMapping("/order/{id}")
//    public String orderPOST(@PathVariable("id") Long id, @ModelAttribute("orderForm") OrderForm orderForm) {
//        deliveryService.insertItem(id, orderForm);
//
//        return "order/배송된지 확인되는 페이지";
//    }
}
