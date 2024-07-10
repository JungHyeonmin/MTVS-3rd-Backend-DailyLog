package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 클래스와 메서드 매핑의 차이는? ㅜ머지..?

/**
 * ## 2-1. Method Mapping
 *
 * DispatcherServlet 이 @Controller 가 달린 컨트롤러 클래스에 웹 요청 처리를 위임하면
 * //    컨트롤러 클래스의 handler Method 에 선언도니 다양한 @RequestMapping 설정 내용에 따른다.
 *
 * `@Controller` 어노테이션이 붙은 클래스는 웹 요청을 처리하는 컨트롤러임을 나타내며,
 * Spring MVC 에서는 `@Controller` 어노테이션이 붙은 클래스를 자동으로 스캔해서 Bean 으로 등록한다.
 * 이후 요청이 들어오면 `@RequestMapping` 어노테이션을 이용하여 어떤 메소드가 요청을 처리할지 지정한다.
 */



// @Controller : 스프링 컨테이너는 @Controller 어노테이션이 지정된 클래스를 빈으로 등록하고, 요청(request)을 해당 컨트롤러에 매핑하여 처리한다.

// @RequestMapping : Spring Web MVC 에서 요청(Request)을 처리하는 데 사용되는 어노테이션
// 상위 요청 order 에 대해서 모든 하위 요청을 선택
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    // @GetMapping : HTTP Get Method 에 해당하는 단축 표현으로 서버의 리소스를 조회할 때 사용
    // /order/regist
    @GetMapping("/regist")
    public String registOrder(Model model) {

        // Model 객체는 Controller 에서 생성된 데이터를 담아 View 로 전달할 때 사용하는 객체이다.
        // Model 은 스프링이 지원하는 기능으로써, key 와 value 로 이루어져있 HashMap 이다.

        // add : 더하다 Attribute : 속성
        // addAttribute(String name, Object value) : value 객체를 name 이름으로 추가한다. 뷰 코드에서는 name 으로 지정한 이름을 통해서 value 를 사용한다.
        // 문자열 객체(GET ...)를 message 이름으로 추가한다.
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메서드 호출함");

        return "mappingResult";
    }


    // @RequestMapping : Spring Web MVC 에서 요청(Request)을 처리하는 데 사용되는 어노테이션이며
    // 이를 통해 어떤 URL 이 어떤 메소드에서 처리되는지, 어떤 HTTP Method 를 처리할지 등을 정할 수 있다.
    
    // RequestMethod : HTTP 요청 메서드를 열거한 Enum 클래스
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.GET)
    public String modifyOrder(Model model) {
        model.addAttribute("message", "GET 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메서드 호출함");

        return "mappingResult";
    }


    @GetMapping("/detail/{orderNo}") // /order/detail/3에서 3은(PathVariable) {}을 값을 표기하는 방법 - 자원을 명시해놓은 (REST API 방식)
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo) { // 변수이름이 {}와 같다면 () 생략 가능
        model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메서드 호출함...");

        return "mapppinResult";
    }


    @RequestMapping
    public String otherRequest(Model model) {

        model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비되지 않음...");

        return "mappingResult";
    }
}
