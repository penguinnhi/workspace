package com.green.SecurityTest.jwt;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

// jwt 토큰 생성 및 토큰의 정보를 조회하는 기능을 구현한 클래스
@Slf4j
@Component // 객체 생성 (이 클래스의 역할이 애매할때..)
public class JwtUtil {
    private SecretKey secretKey;

    //jwtutil 생성자
    //@Value() : application.properties 파일의 내용을 참조
    public JwtUtil(@Value("${spring.jwt.secret}") String secret){
        secretKey = new SecretKeySpec( secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS512.key().build().getAlgorithm());
    }

    // 토큰 생성 메서드
    // String userId : 로그인한 회원의 id
    // String role : 로그인한 회원의 권한
    public String createJwt(String userId,String role){

        return Jwts.builder().signWith(secretKey,Jwts.SIG.HS512) //HS512알고리즘으로 암호화 진행
                .header().add("typ","JWT") //토큰 타입 지정
                .and().claim("userID",userId).claim("role",role) // 로그인 id,role을 payload에 등록
                .issuedAt(new Date(System.currentTimeMillis())) //토큰 발행 시간
                .expiration(new Date(System.currentTimeMillis()+ (1000*60*2) )) // 토큰의 유효기간. 1000=1초 * 60 = 1분 * 60= 1시간
                .compact();
    }

    // jwt 토큰에서 로그인한 회원의 아이디 추출
    public String getUserId(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("userId",String.class);
    }

    // jwt 토큰에서 로그인한 회원의 권한 추출
    public String getRole(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("role",String.class);
    }

    // jwt 토큰의 만료 여부 추출
    // 만료 시 true
    public boolean isExpired(String token){
        try {
            return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
        }catch (ExpiredJwtException e){ // 만료가 지났을 때 발생하는 예외
            // 토큰의 유효기간이 만료됐을 때 catch문의 내용이 실행
            log.info("~ 토큰 유효기간 만료 예외 발생 ~");
            return true;
        }


    }

}
