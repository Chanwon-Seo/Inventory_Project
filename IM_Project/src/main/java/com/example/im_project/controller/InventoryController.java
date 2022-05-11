package com.example.im_project.controller;

import com.example.im_project.config.auth.PrincipalDetails;
import com.example.im_project.controller.form.InventoryForm;
import com.example.im_project.controller.form.UpdateForm;
import com.example.im_project.domain.Inventory;
import com.example.im_project.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/item/new")
    public String inventoryForm(Model model) {
        model.addAttribute("inventoryForm", new InventoryForm());
        return "/inventory/inventoryForm";
    }

    @PostMapping("/item/join")
    public String inventory(@Valid @AuthenticationPrincipal PrincipalDetails principalDetails, InventoryForm inventoryForm, BindingResult result) {

        if (result.hasErrors()) {
            return "inventory/inventoryForm";
        }

        String sessionUser_id = principalDetails.getUsername();
        inventoryService.join(inventoryForm, sessionUser_id);

        return "index";
    }

    @GetMapping("/item/findAll")
    public String findAll(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        String sessionUser_id = principalDetails.getUsername();

        List<Inventory> items = inventoryService.findItemsAll(sessionUser_id);

        model.addAttribute("items", items);
        return "/inventory/inventoryList";
    }

    @GetMapping("/items/{id}/edit")
    public String updateItem(@PathVariable("id") Long id, Model model) {
        UpdateForm updateForm = inventoryService.findInventory(id);

        model.addAttribute("updateForm", updateForm);

        return "inventory/updateForm";
    }

    @PostMapping("/items/{id}/edit")
    public String updateItem(@PathVariable("id") Long id, @ModelAttribute("updateForm") UpdateForm form) {
        inventoryService.updateItem(id, form);

        return "redirect:/item/findAll";
    }

    @PostMapping("/items/{id}/remove")
    public String remove(@PathVariable Long id) {
        inventoryService.remove(id);
        return "redirect:/item/findAll";
    }

}
