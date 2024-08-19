package com.ohgiraffers.securitysession.config.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.net.URLEncoder;


/**
 * 사용자의 로그인 실패 시
 * 실패 요청을 커스텀 하기 위한 핸들러이다.
 *
 * 패키지 구조
 * AuthenticationFailureHandle(interface) -&gt; SimpleUrlAuthenticationFail(class) -&gt; AuthFailHandler
 * 우리는 AuthenticationFilureHandler 구현해야 하지만 기존에 구현이 되었는 SimpleUrlAuthenticationFail 상속받아
 * 응답 메시지와 페이지 경로를 설정할 수 있게 하도록 재정의를 하는 것이다.
 * 페이지 경로와 커스텀을 할 수 있도록 만들어주는 메서드는 setDefaultFailureUrl("경로") 메서드 이다.
 * */
@Configuration
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
    /*
     * 설명 : onAuthenticationFailure 메소드가 호출될 defaultFailureUrl인 경우 리 다이렉션을 수행하는 AuthenticationFailUreHandle.
     * 속성이 설정되어 있지 않은 경우 실패를 일으킨 AuthenticationException의 오류 메시지와 함께 클라이언트에게 401 오류를 응답한다.
     * */



    /**
     * 사용자의 잘못된 로그인 시도를 커스텀 하기 위한 핸들러이다.
     *
     * @param request 사용자 요청 개체
     * @param response 서버 응답값
     * @param exception 발생한 오류를 담는 개체
     * */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String errorMessage = null;

        if(exception instanceof BadCredentialsException){
            // BadCredentialsException 오류는 사용자의 아이디가 DB에 존재하지 않는 경우 비밀번호가 맞지 않는 경우 발생한다.
            errorMessage = "아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.";
        }else if(exception instanceof InternalAuthenticationServiceException){
            // 서버에서 사용자 정보를 검증하는 과정에서 발생하는 에러이다.
            errorMessage = "서버에서 오류가 발생되었습니다.";
        } else if (exception instanceof UsernameNotFoundException) {
            // db에 사용자의 정보가 없는 경우 발생하는 오류이다
            errorMessage = "존재하지 않는 이메일 입니다.";
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            //보안 컨텍스트에 인증 객체가 존재하지 않거나 인증 정보가 없는 상태에서 보안처리된 리소스에 접근하는 경우 발생
            errorMessage = "인증 요청이 거부되었습니다.";
        }else{
            errorMessage = "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다.";
        }
        //URL을 안전하게 인코딩 하는데 사용되는 유틸로 문자열을 URL에 사용가능한 형식으로 인코딩할 수 있다.
        errorMessage = URLEncoder.encode(errorMessage,"UTF-8");
        //오류를 처리할 페이지로 이동시킨다. URL 요청은 servlet에 정의해야함.
        setDefaultFailureUrl("/auth/fail?message="+errorMessage);
        // 부모에 메서드를 호출하여 다음 로직을 수행하도록 하기 위함이다.
        super.onAuthenticationFailure(request,response,exception);
    }
}
