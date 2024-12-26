package org.example.demo_sc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

/**
 * 스프링 시큐리티의 정책, 보안적 설정등등 기술
 */
@Configuration
public class AppSecurityConfig {
    // 모두다 @Bean 처리

    // 2. 전체 페이지 권한 여부설정 (가장 중요, 메인)
    //    - 인증이 필요한 페이지, 필요 없는 페이지 등등 설정
    //    - 로그인 페이지(커스텀), 로그인 성공 후 포워딩 페이지등 지정
    //    - 로그아웃 처리, 등 추가 처리
    //    - csrf 공격 대응 처리
    //    - 기타 필요 처리...
    //    - 시큐리티 5.x -> 6.x 변경되면서 바귄 메소드
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // 1. 인증이 필요한 페이지와 아닌 페이지
                .authorizeRequests()
                     // 아래 페이지는 인증 필요 x
                    .requestMatchers("/login", "/signup", "/user").permitAll()//허가
                     // 나머지 모든 페이지는 인증필요
                    .anyRequest().authenticated()
                .and()
                // 2. 로그인 페이지(커스텀), 로그인 성공 후 포워딩 페이지등 지정
                .formLogin()
                    .loginPage("/login")    // 커스텀 로그인 페이지 이동
                    .defaultSuccessUrl("/") // 로그인 성공하면 홈페이지 포워딩
                .and()
                // 3. 로그아웃 처리, 등 추가 처리
                .logout()
                    .logoutSuccessUrl("/login")  // 인증 없이는 접근이 않되게 구성-> 다시 로그인
                    .invalidateHttpSession(true) // 세션(서버측에 클라이언트 정보 저장관리 객체) 처리
                .and()
                // 4. csrf 공격 대응 처리
                .csrf()
                    .disable()   // 않함!! -> 나중에 활성화!!
                .build();
    }

    // 3. 로그인 처리? 구성
    //    - 인증 관리자 객체 필요 -> 빈 구성 -> DI 처리 가능해짐
    //    - 비밀번호 암호화 설정
    //    - 디비와 연동되는 실제적인 로그인 처리->비즈니스 로직->서비스등록

    // 4. 암호화 관련 모듈 필요 -> 빈 구성 -> DI 처리 가능해짐

    // 1. 예외처리 -> 인증에 상관없이 원래 사용하던대로 자유롭게 접근 가능
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
