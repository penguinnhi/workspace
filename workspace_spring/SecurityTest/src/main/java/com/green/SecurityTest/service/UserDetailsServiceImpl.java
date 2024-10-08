package com.green.SecurityTest.service;


import com.green.SecurityTest.vo.CustomUserVO;
import com.green.SecurityTest.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


// 로그인하려는 회원의 정보를 DB에서 조회할 때는 마음대로 하는 게 아니라
// Security에서 알려주는 방식대로 쿼리를 진행해야함
// UserDetailsService 인터페이스에 정의된 loadUserByUsername() 메서드 안에서
// 로그인 하려는 회원의 정보를 조회해야 함
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final MemberService memberService;


    // 로그인 할 때 저장으로 실행되는 메서드
    // 매개변수 String username : 로그인 요청 시 화면에 입력한 회원 ID
    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("!! UserDetailsServiceImpl 클래스의 loadUserByUsername() 메서드 실행 !!");

        // 로그인 '하려는' 회원의 정보를 조회
        MemberVO loginInfo = memberService.getMemberForLogin(username);

        // 로그인하려는 회원 정보가 없을 때
        if (loginInfo==null){
            throw new UsernameNotFoundException("회원 정보 없음");
        }

        // 조회한 정보를 CustomUserVO 객체에 담아줌
        CustomUserVO customUser = new CustomUserVO(loginInfo);

        // 실제 로그인을 처리하는 AuthenticationManager 에게 로그인 정보를 전달 하는 중
        return customUser;
    }


}
