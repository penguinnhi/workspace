package com.green.SecurityTest.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;


/*
흐름 이해하기

시큐리티를 사용한 로그인은 먼저 UsernamePasswordAuthenticationFilter 클래스로부터 시작한다.
UsernamePasswordAuthenticationFilter는 로그인을 시도하면
로그인시 입력한 아이디와 비밀번호를 가져오는 역할을 한다.

UsernamePasswordAuthenticationFilter는 로그인 요청에 대해서만 동작
아무것도 설정하지 않으면 "/login" 요청을 로그인 하는 요청으로 인지함
로그인 요청의 변경은 생성자에서 진행.

우리가 상속받은 filter는 Form 방식의 로그인에서는 자동으로 실행되지만
jwt를 사용한 로그인에서는 UsernamePasswordAuthenticationFilter가 실행되지 않는다.
따라서, SecurityConfig 클래스에 우리가 만든 LoginFilter 클래스가 실행될 수 있도록 설정해야 함
 */
@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    // AuthenticationManager 객체 생성 (의존성 주입)
    // 실제 로그인 검증을 실행하는 객체
    private final AuthenticationManager authenticationManager;

    public LoginFilter(AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;

        //로그인 요청 url 변경
        setFilterProcessesUrl("/member/login");

        //아이디, 비밀번호 전달되는 name 변경
        setUsernameParameter("memId");
        setPasswordParameter("memPw");
    }

    //로그인 요청 시 최초로 실행되는 메서드
    /*
    해당 메서드에서는 로그인 요청 시 전달되는 아이디, 비번을 받아
    AuthenticationManager에 전달.

    AuthenticationManager가 실제로 로그인 로직을 실행하는 객체

    프론트에서 입력받은 아이디와 비밀번호는 특별한 설정을 하지 않으면
    username, password 라는 이름으로 값을 전달받게 설정되어 있음
    전달되는 아이디와 비번의 이름 변경은 생성자에서 진행

    */

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("LoginFilter 클래스의 attemptAuthentication() 실행");

        //우리가 입력한 아이디, 비번 가져오기 (임시)
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        log.info("우리가 입력받은 아이디 : "+username);
        log.info("우리가 입력받은 비밀 번호 : {}",password);

        log.info("아이디 {}, 비밀번호 {}",username,password);

        // 아래의 클래스는 아이디와 비밀번호를 AuthenticationManager 클래스에
        // 아이디와 비번을 전달할 수 있는 보안이 좋은 통
        // 이 통에 아이디와 비번을 담아서 AuthenticationManager에 전달
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,password,null);


        return authenticationManager.authenticate(authToken);
    }

    //로그인 성공 시 실행되는 메서드
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("로그인 성공");



//        super.successfulAuthentication(request, response, chain, authResult);
    }

    // 로그인 실패 시 실행되는 메서드
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.info("로그인 실패");
//        super.unsuccessfulAuthentication(request, response, failed);
    }


}
