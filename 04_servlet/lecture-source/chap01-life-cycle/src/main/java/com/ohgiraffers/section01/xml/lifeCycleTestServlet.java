package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// HttpServlet 을 상속받아서 @Override 해서 servlet 으로 사용할 수 있다.
// servlet 은 TomCat 의 메서드를 오버라이딩 해서 커스텀해서 사용한다.
public class lifeCycleTestServlet extends HttpServlet {

    private int initCount = 1;
    private int getCount = 1;
    private int destroyCount = 1;

    /**
     * 1. 첫 요청이면, 객체를 생성하며 init( ) 메소드를 호출한다.
     *     1. init( ) : 서블릿 컨테이너에 의해 호출되며 최초 요청 시에만 실행하고 두 번째 요청부터는 호출하지 않는 메소드이다.
     *     2. load-on-startup 속성값을 설정할 경우 서버가 구동할 때 객체를 생성하며 init( ) 메소드를 호출한다.
     *     3. 서블릿도 클래스이므로 객체를 생성해 작동한다. 따라서 서버 구동 시 서블릿을 생성하면 톰캣 최초 수행 시에는 시간이 좀 걸리지만, 클라이언트 요청에는 더 빠르게 응답할 수 있다.
     * 2. 이후 작업이 실행 될 때마다 service() 메소드가 요청한 HTTP Type  에 따라 doGet(), doPost() method 를 호출한다.
     *     1. service() : 서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 메소드 동작 이후에 동작하고, 두 번째 요청부터는 init() 메소드 호출 없이 바로 동작한다.
     * 3. 최종적으로 Servlet 이 서비스 되지 않을 때 destroy() 메소드가 호출된다.
     *     1. destroy() : 컨테이너, 즉 서버가 종료될 때 또는 서블릿의 내용이 변경되어 재컴파일 될 때 호출되는 메소드로 주로 자원을 반납하는 용도로 사용한다.
     * - Servlet 의 주요 메소드는 Servlet 의 Life cycle 과 유사하다.
     */

    // ctrl + o : 상속, 구현 가능한 메서드 목록 호출

    // 생명주기에 관련된 메서드 (init, doGet, destroy)

    // HttpServlet 에서 상속받는다.
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 메서드 호출 : " + initCount++);
    }

    // HttpServlet 에서 상속받는다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xml 매핑 doGet() 메서드 호출 : " + getCount++);
    }

    // 서비스도 doGet 처럼 동작 가능
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    // GenericServlet 에서 상속받는다.
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy() 메서드 호출 : " + destroyCount++);
    }
}
