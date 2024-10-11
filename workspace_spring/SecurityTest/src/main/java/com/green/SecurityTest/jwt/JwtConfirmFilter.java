package com.green.SecurityTest.jwt;

import com.green.SecurityTest.vo.CustomUserVO;
import com.green.SecurityTest.vo.MemberVO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// client가 가져온 토큰이 유효한지 검사하는 필터
// 실행 순서
// 요청 > JwtConfirmFilter 실행 > controller 실행
@Slf4j
@RequiredArgsConstructor
public class JwtConfirmFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    // 토큰 검증 시 실행되는 메서드
    // 모든 요청에 대해 컨트롤러가 실행되기 전 무조건 실행되는 메서드
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("! 토큰 검증 시작 !");

        // 요청 시 헤더에 담겨오는 토큰 확인
        String authorization = request.getHeader("Authorization");

        // 토큰이 없으면 (로그인 하지 않았을 때)
        if (authorization==null || !authorization.startsWith("Bearer ")){
            log.info("토큰이 존재하지 않음");

            // 다음 필터 계속해서 진행하세요
            filterChain.doFilter(request,response);

            return;
        }

        // ---------------토큰 유효성 검사
        // 토큰추출
        String token = authorization.split(" ")[1];

        //1. 토큰의 만료일 검사
        if (jwtUtil.isExpired(token)){
            log.info("토큰 유효기간 만료");

            // 다음 필터 계속해서 진행하세요
            filterChain.doFilter(request,response);

            return;
        }

        // 아래의 코드는 토큰이 존재하고 만료기간이 지나지 않았을 때만 실행 (유효한 토큰)

        // 토큰의 유저Id, 권한을 추출
        String userId = jwtUtil.getUserId(token);
        String role = jwtUtil.getRole(token);

        log.info("로그인한 유저의 ID : {}, 로그인한 유저의 권한 : {}",userId,role);

        // 인증된 유저의 정보를 MemberVo에 저장
        MemberVO member = new MemberVO();
        member.setMemId(userId);
        member.setMemRole(role);
        member.setMemPw("tempPw"); // 비밀번호 정보를 임의로 세팅

        //CustomUserVO에 member 정보 저장
        CustomUserVO customUserVO = new CustomUserVO(member);

        //위에서 가져온 회원 정보를 security에서 사용하는 객체에 저장
        Authentication authentication = new UsernamePasswordAuthenticationToken(customUserVO, null, customUserVO.getAuthorities());

        //회원 정보를 인증된 사용자로 등록
        SecurityContextHolder.getContext().setAuthentication(authentication);





        // 다음 필터 계속해서 진행하세요
        filterChain.doFilter(request,response);

    }


}
