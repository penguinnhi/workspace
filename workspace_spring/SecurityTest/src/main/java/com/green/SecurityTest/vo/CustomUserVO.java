package com.green.SecurityTest.vo;



import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



// 유저의 정보를 저장할 클래스
// security 보안내용이 추가된 클래스
// 데이터베이스에서 조회한 로그인하려는 회원의 정보를 담을 통
@RequiredArgsConstructor
public class CustomUserVO implements UserDetails {
    private final MemberVO memberVO;


    // 유저의 권한 '목록' 조회
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 목록을 저장할 통
        Collection<GrantedAuthority> collection = new ArrayList<>();

        // memberVO에 저장된 권한을 하나씩 빼서 collection 객체에 추가하는 코드
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return memberVO.getMemRole();
            }
        });

        return collection;
    }

    // 유저의 비밀번호 리턴
    @Override
    public String getPassword() {
        return memberVO.getMemPw();
    }

    // 유저의 아이디 리턴
    @Override
    public String getUsername() {
        return memberVO.getMemId();
    }

    // 만료되지 않은 계정이니?
    @Override
    public boolean isAccountNonExpired() {
        return true; // 만료가 안 됐다
    }

    // 잠겨있지 않은 계정이니?
    // 원래는 비밀번호 몇번 틀리면 잠긴다 이런 기능
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
