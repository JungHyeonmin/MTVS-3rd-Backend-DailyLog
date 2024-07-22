package com.ohgiraffers.mvcpractice.controller;

import com.ohgiraffers.mvcpractice.model.dto.InventoryItemDTO;
import com.ohgiraffers.mvcpractice.model.dto.PlayerDTO;
import com.ohgiraffers.mvcpractice.model.service.OpenInventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class OpenInventoryController {

    private OpenInventoryService openInventoryService;

    public OpenInventoryController(OpenInventoryService openInventoryService) {
        this.openInventoryService = openInventoryService;
    }

    @GetMapping("openInventory")
    public String openInventory(@SessionAttribute("loginPlayer") PlayerDTO loginPlayer, Model model) {

        List<InventoryItemDTO> inventoryItemList = openInventoryService.findAllInventory(loginPlayer);

        model.addAttribute("inventoryItemList", inventoryItemList);

        return "Inventory";
    }
}
