package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;

// servlet 에 의존하지 않게 해준다. - PSA-서비스추상화 (다른 모델이 의존해서 사용하지 않게 보이게 해주는 것)
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller // 일종의 컴포넌트
public class MethodMappingTesController {

    // 1. 메서드에서 매핑하기
    // DispatcherServlet : return 한 문자열을 어떻게 보여줄지 ViewResolver 를 이용해서 문자열을 해석하고
    // ViewResolver : 구현체에 맞춰서 html 또는 jsp 파일로 변환해준다.
    @RequestMapping("/menu/regist") // 매핑하고자 하는 url 작성 // 메서드를 설정하지 않으면 GET, POST 구분안하고 전부 받는다.
    public String menuRegist(Model model) {

        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메서드 호출함...");

        return "mappingResult"; // templates 폴더의 mappingResult.html (파일 경로말고 파일명만 쓴다.)
    }

    // value : 해당 url 로 온 요청만 받는다. method : 허용할 메서드를 선택한다.
    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {

        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메서드 호출함...");

        return "mappingResult";
    }

    // 요청 메서드 전용 어노테이션
    /**
     * 요청 메서드        어노테이션
     * POST             @PostMapping
     * GET              @GetMapping
     * PUT              @PutMapping
     * DELETE           @DeleteMapping
     * PATCH            @PatchMapping
     */

}
