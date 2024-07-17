package com.ohgiraffers.chap08crudpractice.menu.controller;

import com.ohgiraffers.chap08crudpractice.menu.model.dto.CategoryDTO;
import com.ohgiraffers.chap08crudpractice.menu.model.dto.MenuDTO;
import com.ohgiraffers.chap08crudpractice.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {

    // Logger : 로그를 기록하기 위한 Log4j 2 라이브러리. -> MenuController 클래스에서 로그를 기록하는 데 사용
    // LogManager : Log4j 2 라이브러리에서 로그 객체를 관리하는 클래스.
    // getLogger(MenuController.class) : MenuController 클래스와 연관된 Logger 인스턴스를 반환.
    // 보통 로그를 남길 때 어떤 클래스에서 기록된 로그인지 알기 위해 클래스명을 인자로 전달한다.
    private static final Logger logger = LogManager.getLogger(MenuController.class);

    // Service 로 넘기기 위한 객체 생성
    private final MenuService menuService;

    // 스프링의 다국어 지원을 위해 사용되는 인터페이스
    private final MessageSource messageSource;

    public MenuController(MenuService menuService, MessageSource messageSource) {

        this.menuService = menuService;
        this.messageSource = messageSource;

    }

    /**
     * index.html 필요 메서드
     */

    // 전체 메뉴 조회 페이지 이동 메서드 - GetMapping (list 페이지는 접속하자마자 db의 내용 출력)
    @GetMapping("/list")
    public String findMenuList(Model model) { // model 은 hashMap 형태로 구성되어 있으며 값을 전달할때 바구니 역할을 한다.

        List<MenuDTO> menuList = menuService.findAllMenu(); // 요청:서비스에게 모든 메뉴를 받도록 -> 응답:서비스에서 모든 메뉴를 MenuDTO 타입의 리스트에 넣는다.

        // model 에 키와 값을 저장한다.
        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    // 신규 메뉴 등록 페이지 이동 메서드 - GetMapping
    // 단순 페이지 이동은 GetMapping void 메서드를 사용하여 간단하게 표기한다.
    @GetMapping("regist")
    public void registPage(){}

    //value : 요청으로 온 url (main/category), produces : JSON 형식의 데이터를 UTF-8 인코딩으로 반환한다는 것을 나타낸다.
    /// @ResponseBody : 메서드가 반환하는 값을 HTTP 응답 본문에 직접 쓰도록 지시한다.
    @GetMapping(value="category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        // 메서드를 호출하여 모든 카테고리 목록을 가져오고, 이를 JSON 형식을 반환한다.
        return menuService.findAllCategory();
    }

    /**
     * regist.html 필요 메서드
     */

    // 신규 메뉴 등록 메서드 - PostMapping (db에 값을 추가하는 메서드)
    // MenuDTO : 추가하려고 하는 DTO 객체
    // RedirectAttributes : 리다이렉트 후에도 데이터를 유지하기 위한 객체
    // Locale : 클라이언트의 로케일 정보를 담고 있는 객체
    @PostMapping("regist")
    public String registMenu(MenuDTO newMenu, RedirectAttributes rttr, Locale locale) {

        // 메서드를 호출하여 새로운 메뉴를 DB에 등록
        menuService.registNewMenu(newMenu);

        // 로케일 정보를 로그에 기록한다.
        logger.info("Locale : {}", locale);

        // 성공 메시지를 플래시 속성에 추가한다. 메세지는 로케일에 맞춰 'messageSource' 에 가져온다.
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));
        //rttr.addFlashAttribute("successMessage", "신규 메뉴 등록에 성공하셨습니다.");

        return "redirect:/menu/list";
    }

}
