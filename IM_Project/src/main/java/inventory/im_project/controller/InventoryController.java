package inventory.im_project.controller;

import inventory.im_project.controller.form.InventoryForm;
import inventory.im_project.domain.Inventory;
import inventory.im_project.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/inventory/new")
    public String createForm(Model model) {
        model.addAttribute("inventoryForm", new InventoryForm());
        return "inventory/createInventoryItemForm";
    }

    @PostMapping("/inventory/new")
    public String create(@Valid InventoryForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "inventory/createInventoryItemForm";
        }
        inventoryService.join(form);

        return "redirect:/";
    }

    @GetMapping("/inventory/List")
    public String list(Model model) {
        List<Inventory> items = inventoryService.findInventoryByAll();
        model.addAttribute("items", items);
        return "inventory/inventoryList";
    }
}
