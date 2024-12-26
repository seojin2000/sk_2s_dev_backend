package org.example.demo_sc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

/**
 * 스프링 시큐리티의 정책, 보안적 설정등등 기술
 */
@Configuration
public class AppSecurityConfig {
    // 모두다 @Bean 처리

    // 1. 전체 페이지 권한 여부설정
    //    - 인증이 필요한 페이지, 필요 없는 페이지 등등 설정
    //    - 로그인 페이지(커스텀), 로그인 성공 후 포워딩 페이지등 지정
    //    - 로그아웃 처리, 등 추가 처리
    //    - csrf 공격 대응 처리
    //    - 기타 필요 처리...

    // 2. 로그인 처리? 구성
    //    - 인증 관리자 객체 필요 -> 빈 구성 -> DI 처리 가능해짐
    //    - 비밀번호 암호화 설정
    //    - 디비와 연동되는 실제적인 로그인 처리->비즈니스 로직->서비스등록

    // 3. 암호화 관련 모듈 필요 -> 빈 구성 -> DI 처리 가능해짐

    // 4. 예외처리 -> 인증에 상관없이 원래 사용하던대로 자유롭게 접근 가능
    //    - h2 console
    //    - 정적 데이터 -> resource/static/js|css|image|...
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 다음 등록된 내용은 보안 정책이 무시된다
        return webSecurity -> webSecurity.ignoring()
                .requestMatchers(toH2Console()) // ~/h2-console
                .requestMatchers("/static/**")// 정적 데이터 모든것
                ;
    }

}
