package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv) {
        
        /* Member는 이후에 필요할 때 추가 */
        mv.addObject("member", new MemberDTO("홍길동", 20, '남', "서울시 서초구"));

        /* hello도 이후에 필요할 때 추가 */
        mv.addObject("hello", "hello!<h3>Thymeleaf</h3>");

        /* view 이름부터 설정 */
        mv.setViewName("/lecture/expression");

        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv) {

        mv.addObject("num", 1);
        mv.addObject("str", "바나나");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        memberList.add(new MemberDTO("유관순", 22, '여', "서울시 노원구"));
        memberList.add(new MemberDTO("장보고", 40, '남', "서울시 종로구"));
        memberList.add(new MemberDTO("신사임당", 30, '여', "서울시 성북구"));

        mv.addObject("memberList", memberList);

        mv.setViewName("/lecture/conditional");

        return mv;
    }

    @GetMapping("/etc")
    public ModelAndView etc(ModelAndView mv) {

        SelectCriteria selectCriteria = new SelectCriteria(1, 10, 3);

        mv.addObject(selectCriteria);

        MemberDTO member = new MemberDTO("홍길동", 20, '남', "서울시 서초구");

        mv.addObject("member", member);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        memberList.add(new MemberDTO("유관순", 22, '여', "서울시 노원구"));
        memberList.add(new MemberDTO("장보고", 40, '남', "서울시 종로구"));
        memberList.add(new MemberDTO("신사임당", 30, '여', "서울시 성북구"));

        mv.addObject("memberList", memberList);

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("m01", new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        memberMap.put("m02", new MemberDTO("유관순", 22, '여', "서울시 노원구"));
        memberMap.put("m03", new MemberDTO("장보고", 40, '남', "서울시 종로구"));
        memberMap.put("m04", new MemberDTO("신사임당", 30, '여', "서울시 성북구"));

        mv.addObject("memberMap", memberMap);

        mv.setViewName("/lecture/etc");

        return mv;
    }


    @GetMapping("/fragment")
    public ModelAndView fragment(ModelAndView mv){
        mv.addObject("test1", "values1");
        mv.addObject("test2", "values2");
        mv.setViewName("/lecture/fragment");
        return mv;
    }
}
