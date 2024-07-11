package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {

        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함...");

        return "result";
    }


    // 재요청으로 목록을 볼때 좋다.
    @GetMapping("string-redirect")
    public String stringRedirect() {

        return "redirect:/"; // / : 루트 요청
    }


    @GetMapping("string-redirect-attr")
    public String stringRedirectAttr(RedirectAttributes rttr) {

        // session 의 공간을 잠깐 만들어서 사용하고 없애는 방법, flash 의 이름을 원래 있던 값으로 사용하면 원래의 값이 사라진다.
        rttr.addFlashAttribute("flashMessage1", "리다이렉트 attr 사용하여 redirect...");

        return "redirect:/";
    }


    // 뷰리졸버라는 개념을 다룰때 타임리프나 js를 위한 전용 뷰가 있는데 가상의 뷰를 들어올 때 다른방식의 뷰를 해석하는 방법이 있다.
    //
    // model 은 단독으로 사용 가능, view 는 불가능
    @GetMapping("modelandview")
    public ModelAndView modelAndVeiwReturning(ModelAndView mv) {

        mv.addObject("forwardMessage", "ModelAndView를 이용한 모델과 뷰 반환");
        mv.setViewName("result");

        return mv;
    }


    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv) {

        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirectAttr(ModelAndView mv, RedirectAttributes rttr) {

        rttr.addFlashAttribute("flashMessage2", "ModelAndView 를 이용한 redirect attr");
        mv.setViewName("redirect:/");

        return mv;
    }
}
