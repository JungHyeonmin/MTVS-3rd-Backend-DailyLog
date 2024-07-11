package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * 현업에서 많이 사용하는 어노테이션, 메서드들이다.
 * 전부 외워..
 * 7/11일  13시 32분 수업영상에 정리하는 영상 있음
 */

@Controller
@RequestMapping("/first/*") // first 로 오는 모든 요청을 여기서 응답한다. first 파일 밑의 파일을 모두 탐색한다.
@SessionAttributes("id")
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

    @GetMapping("modify")
    public void modify() {
    }


    // @RequestParam 은 속성명(name)이 완벽하게 같아야 작동한다. 값이 다르거나 없는 경우에 요청하는 파라미터가 잘못됐다는 400번 에러가 발생한다.
    // 값이 다를 시 (required = false) 설정을 해야한다. 그러면 없다면 null(초기화값)로 표현한다.
    // 값이 없거나 다른 타입일 경우 (defaultValue = "0") 설정을 해야한다. 그렇다면 defaultValue 에 지정한 값이 나온다.
    // -> 값을 무조건 채워서 오는 것을 원한다면 <input>태그 에서 required 를 추가하면된다.

    // @RequestParam 은 생략이 가능하다. 하지만 부가적인 속성 추가, 가독성을 위해서 어노테이션을 적는 것을 권장한다.
    @PostMapping("modify")
    public String modifyMenuPrice(Model model
            , @RequestParam(required = false) String modifyName
            , @RequestParam(defaultValue = "0") int modifyPrice) {

        System.out.println("modifyName = " + modifyName);
        System.out.println("modifyPrice = " + modifyPrice);

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "원으로 가격을 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    // 값이 많을 때는 Map 을 이용한다. (하지만 좋지 못한 형태이다. 그래서 DTO 를 만들어서 사용하는 것을 추천한다.)
    @PostMapping("modifyAll")
    public String modifyAll(Model model, @RequestParam Map<String, String> parameters) {

        String modifyName = parameters.get("modifyName2");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = "메뉴의 이름을 " + modifyName + "(으)로, 가격을 " + modifyPrice + "원으로 변경하였습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }


    // @ModelAttribute 가 제일 편하기 때문에 가장 많이 사용하고, Session 에서도 사용한다.
    @GetMapping("search")
    public void search() {
    }

    @PostMapping("search")
    public String searchmenu(@ModelAttribute("menu") MenuDTO menu) { // name : MenuDTO -> 별칭("menu"), value : menu
        // @ModelAttribute 를 생략하고 사용할 수 있다. 하지만 속성명 변경 불가능 + 가독성을 위해서 작성하는 것을 권장한다.(권장한다 == 그냥 해ㅋ)

        System.out.println(menu);

        return "first/searchResult";
    }


    @GetMapping("login") // 핸들러 메서드 작성
    public void login() {
    }

    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id) {

        session.setAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {
        // 로그아웃 하는 방법 1. 세션 연결 해제
        // session.removeAttribute("id");

        // 로그아웃 하는 방법 2. 세션 시간 설정
        //session.setMaxInactiveInterval(600);

        // ?
        session.invalidate();

        return "first/loginResult";
    }

    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {

        // 클래스 레벨에서 Session 영역을 선언 // addAttribute 를 사용하면 invalidate()를 사용할 수 없다.
        model.addAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus status) {

        // session.invalidate()를 호출해서 세션을 무효화 시칸다. -> Spring 에서 지원하기 때문에 servlet 에 대한 의존성을 낮춘다.
        status.setComplete();

        return "first/loginResult";
    }

    // 페이지 포워딩
    @GetMapping("body")
    public void body() {
    }

    @PostMapping("body")
    public void bodyTest(@RequestBody String body,
                         @RequestHeader("content-type") String contentType,
                         @CookieValue(value = "JSESSIONID", required = false) String sessionId) throws UnsupportedEncodingException {
        // required = false : 값이 없어도 에러처리 x
        // 쿼리 스트링과 비슷하게 콘솔에서 출력한다.
        System.out.println(URLDecoder.decode(body, "UTF-8"));
        System.out.println(contentType);
        System.out.println(sessionId);
    }
}