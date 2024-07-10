package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 클래스와 메서드 매핑의 차이는? ㅜ머지..?


@Controller
@RequestMapping("/order/*") // 상위 요청 order 에 대해서 모든 하위 요청을 선택
public class ClassMappingTestController {

    // /order/regist
    @GetMapping("/regist")
    public String registOrder(Model model) {

        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메서드 호출함");

        return "mappingResult";
    }


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
