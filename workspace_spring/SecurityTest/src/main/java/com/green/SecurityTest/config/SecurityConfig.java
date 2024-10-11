package com.green.SecurityTest.config;

import com.green.SecurityTest.jwt.JwtConfirmFilter;
import com.green.SecurityTest.jwt.JwtUtil;
import com.green.SecurityTest.jwt.LoginFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PutMapping;


// 이 클래스에서 시큐리티의 인증 및 인가에 대한 설정
@Configuration // 클래스에 대한 객체 생성 어노테이션
@EnableWebSecurity // 해당 클래스가 security 설정 클래스임을 인지
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationConfiguration configuration;

    private final JwtUtil jwtUtil;

    // 비밀번호를 암호화 시켜줄 수 있는 객체 생성 메서드
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //AuthenticationManager 객체 생성 메서드
    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }


    // -- 인증 및 인가에 대한 설정을 진행하는 메서드 --
    // 이러한 메서드는 공식 문서의 가이드에 설명된 내용을 토대로 구현

    // 프로젝트 생성 시 security를 사용하겠다고 선언만 하면
    // 우리가 만든 모든 요청에 대해 인증을 받도록 기본 설정이 되어 있어
    // 어떠한 페이지로도 접근이 불가능하다.
    // 아래 메서드에서 인증 및 인가 설정을 하게 되면
    // 기본적으로 모든 요청을 막던 설정이 우리가 작성한 코드의 설정대로 진행하게 된다.

    // Bean 어노테이션은 지금까지와의 어노테이션과 다르게 메서드 위에 작성한다.
    @Bean // 메서드의 리턴 데이터를 객체로 생성하는 기능
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // throws Exception : 여기에서 예외가 발생할 경우 다른 데로 던지겠음



        // csrf - Cross-site Request Forgery
        // csrf 공격에 대한 방어기제를 사용하지 않겠다.
        // jwt 로그인은 csrf 공격에 상대적으로 안전하기 때문에 사용 안 함
        httpSecurity.csrf(auth -> auth.disable());

        // form 로그인 방식을 미사용으로 지정
        // 리액트를 제외한 나머지 전통적인 프론트 단(thymeleaf, jsp)을 만드는 기술을 사용할 때는
        // form 방식의 로그인을 채택
        httpSecurity.formLogin(auth -> auth.disable());

        // http basic 인증 방식 미사용
        // http basic : 요청 헤더에 id, pw 값을 담아서 백서버에 전달하는 방식
        // 보안에 취약, 요즘엔 안 씀
        // http basic 방식을 사용하면 로그인 정보를 백서버의 세션에 저장
        httpSecurity.httpBasic(auth -> auth.disable());

        // 백서버의 세션 사용을 비활성화
        httpSecurity.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        );

        // LoginFilter 앞에 JwtConfirmFilter를 추가
        httpSecurity.addFilterBefore(new JwtConfirmFilter(jwtUtil), LoginFilter.class);

        //LoginFilter 클래스를 Filter에 추가 (모르겠음!)
        httpSecurity.addFilterAt(new LoginFilter(getAuthenticationManager(configuration),jwtUtil), UsernamePasswordAuthenticationFilter.class);

        // 인증 및 인가 설정
        httpSecurity.authorizeHttpRequests(
                auth -> auth.requestMatchers(
                        "/",
                        "/member/loginForm",
                        "/member/joinForm",
                        "/member/join",
                        "/member/login",
                        "/test1").permitAll() // 인증 설정 "/" 요청은 누구나 접근 가능
                        .requestMatchers("/test3").hasRole("USER")
                        .requestMatchers("/test4").hasRole("ADMIN")
                        .requestMatchers("/test5").hasAnyRole("MANAGER","ADMIN")
                        .anyRequest().authenticated()
                // any~ : 나머지 요청은 인증 받아야 접근 가능


        );

        return httpSecurity.build();
    }

}
