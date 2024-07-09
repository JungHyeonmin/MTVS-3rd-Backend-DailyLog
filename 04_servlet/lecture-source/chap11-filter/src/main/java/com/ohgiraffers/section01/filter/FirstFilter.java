package com.ohgiraffers.section01.filter;

// Filter 구현은 jakarta Servlet 을 임포트해준다.

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/first/*") // first url 하위 페이지 모두 적용한다.
public class FirstFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { // filter 인스턴스가  속성이 될때 한번 출력

        System.out.println("FirstFilter init() 호출");
    }

    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 서블릿 호출 이전에 수행할 내용
        System.out.println("Filter doFilter 호출");

        // 다음 필터의 doFilter 호출(다음 필터가 없는 경우 servlet 을 호출)
        // 필터 : doFilter() 메서드를 통해 요청을 가로채고, 필요한 로직을 실행한 뒤, 요청을 다음 목적지(다른 필터 또는 서블릿)로 전달한다.
        filterChain.doFilter(servletRequest, servletResponse);

        // 서블릿 호출 이후에 수행할 내용
        System.out.println("Servlet 요청 수행 완료!");
    }

    @Override
    public void destroy() { // Tomcat 이 종료될 때 출력되는 메서드

        System.out.println("FirstFilter destroy() 호출");
    }
}
