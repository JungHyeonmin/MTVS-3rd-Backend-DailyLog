package com.ohgiraffers.mvcpractice.controller;

import com.ohgiraffers.mvcpractice.model.dto.ItemDTO;
import com.ohgiraffers.mvcpractice.model.dto.PlayerDTO;
import com.ohgiraffers.mvcpractice.model.service.GetItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.lang.management.PlatformLoggingMXBean;
import java.util.List;

@Controller
public class GetItemController {

    private GetItemService getItemService;

    public GetItemController(GetItemService getItemService) {
        this.getItemService = getItemService;
    }

    @GetMapping("getItem")
    public String getItem(Model model) {
        List<ItemDTO> itemList = getItemService.getItem();
        System.out.println(itemList);
        model.addAttribute("itemList", itemList);

        return "getAbleItem";
    }


    @PostMapping("/addItem")
    public String addItem(@RequestParam int itemNo,@SessionAttribute("loginPlayer") PlayerDTO loginPlayer) {

        //model.getAttribute("") // model 에 user 정보
        getItemService.addInventory(loginPlayer.getPlayerNo(), itemNo);
        
        return "redirect:/getItem";
    }
}
