package com.ohgiraffers.mvcpractice.controller;

import com.ohgiraffers.mvcpractice.model.service.PurchaseItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchaseItemController {

    private PurchaseItemService purchaseItemService;

    public PurchaseItemController(PurchaseItemService purchaseItemService) {
        this.purchaseItemService = purchaseItemService;
    }

    @GetMapping("purchaseItem")
    public String purchaseItem() {


        return "/purchaseItem";
    }
}
