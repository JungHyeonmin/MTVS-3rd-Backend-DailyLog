package com.ohgiraffers.chap08crudtest.controller;

import com.ohgiraffers.chap08crudtest.model.dto.MenuDTO;
import com.ohgiraffers.chap08crudtest.model.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    // list 페이지 이동 후 조회 (get)
    @GetMapping("/list")
    public String listPage(Model model) {

        // 모델에 담기전에 db 에서 받아와야한다.

        // Get은 뷰에 보내주는 역할이므로 뷰에 어떤 값을 보내줄것인지 생각해야한다. - 메뉴 리스트를 가져와

        List<MenuDTO> menuList = menuService.getAllList();
        model.addAttribute("menuList", menuList);

        // 1. db에서 결과값을 받아오면 리스트에 저장한다.
        // 2. 리스트를 model.addAttribute 에 담아준다.

        return "menu/list";
    }

    // regist 페이지 이동 (get)
    @GetMapping("regist")
    public void registPage() {
    }

    // regist 페이지에서 등록 (post)
    @PostMapping("/regist")
    public String regist(MenuDTO menu) {

        System.out.println(menu.toString());
        // post로 받았는데 이 값들을 어떻게 보내지? -> @ModelAttribute
        menuService.registMenu(menu);

        return "redirect:/menu/list";
    }


}
