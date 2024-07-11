package com.ohgiraffers.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
@RequestMapping("/first/*") // first 로 오는 모든 요청을 여기서 응답한다.
public class FirstController {

    // 보여주는 건 뷰포트로 보여주고
    // 실제 전환은 포스트매핑에서 한다?

    // /first/regist 요청이 들어오면
    // void 메서드인 경우 요청 주소가 곧 view 의 이름이 된다.
    // return "/first/regist" 를 작성해주는 것과 같다.
    @GetMapping("regist")
    public void regist() {
    }

    /**
     * 1. WebRequest 로 요청 파라미터 전달 받기
     */

    // 아런 request 방식보다 더 쉬운 방법을 더 많이 사용한다.
    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {// request : 파라미터 값을 뺄때도 사용한다. modal 에 의존하지 말고 WebRequest 를 사용해라

        String menuName = request.getParameter("menuName");
        int menuPrice = Integer.parseInt(request.getParameter("menuPrice"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = menuName + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
                + menuPrice + "원으로 등록하셨습니다!";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }
}
