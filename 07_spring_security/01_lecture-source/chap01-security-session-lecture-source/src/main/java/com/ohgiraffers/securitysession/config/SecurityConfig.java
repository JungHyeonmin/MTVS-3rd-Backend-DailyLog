package com.ohgiraffers.securitysession.config;


import com.ohgiraffers.securitysession.common.UserRole;
import com.ohgiraffers.securitysession.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;


    /*
     * 비밀번호를 인코딩하기 위한 Bean
     * Bcrypt는 비밀번호 해싱에 가장 많이 사용되는 알고리즘 중 하나이다.
     *
     * 사용 이유
     * 1. 보안성 : 해시 함수에 무작위 솔트를 적용하여 생성한다.
     * 2. 비용 증가 : 매개변수에 값을 주면 암호 생성 시간을 조절할 수 있어 무차별 공격을 어렵게 한다.
     * 3. 호환성 : 높은 보완 수준 및 데이터베이스에 저장하기 쉬운 특징
     * 4. 알고리즘 신뢰성 : 보안에 논의 평가를 거친 알고리즘으로 문제없이 계속 사용 중
     * */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean // 정적리소스의 대한 요청을 제외하겠다는 설정 static 파일 하위
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> { // 서버의 리소스에 접근 가능한 권한을 설정함
            auth.requestMatchers("/auth/login","/user/signup","/auth/fail","/").permitAll();
            auth.requestMatchers("/admin/*").hasAnyAuthority(UserRole.ADMIN.getRole());
            auth.requestMatchers("/user/*").hasAnyAuthority(UserRole.USER.getRole());
            auth.anyRequest().authenticated();
        }).formLogin(login ->{
            login.loginPage("/auth/login"); // 로그인 페이지에 해당되는 서블릿이 존재해야 한다.
            login.usernameParameter("user"); // 사용자 id 입력 필드 (input의 name과 일치)
            login.passwordParameter("pass"); // 사용자 pass 입력 필드 (input의 name과 일치)
            login.defaultSuccessUrl("/",true);// 로그인 성공시 이동할 페이지(서블릿이 존재해야 한다.)
            login.failureHandler(authFailHandler);
        }).logout(logout ->{
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
            logout.deleteCookies("JSESSIONID"); // 로그아웃 시 사용자의 JSESSIONID 삭제
            logout.invalidateHttpSession(true);// 세션을 소멸하도록 허용하는 것
            logout.logoutSuccessUrl("/"); // 로그아웃시 이동할 페이지 설정
        }).sessionManagement(session ->{
            session.maximumSessions(1);// session의 허용 개수를 제한
            session.invalidSessionUrl("/"); // 세션만료시 이동할 페이지
        }).csrf(csrf -> csrf.disable());

        return http.build();
    }
}
