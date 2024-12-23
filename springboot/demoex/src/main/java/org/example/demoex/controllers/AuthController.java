package org.example.demoex.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 인증 처리
 *  - URL prefix 처리를 통한 URL 구성 실습
 *      - auth
 */
@RequestMapping("/auth") // 컨트롤러 내부의 모든 라우트함수는 앞쪽에 /auth 붙인다!!
@Controller
public class AuthController {
    // 실습 /auth/login 처리, get방식 정의 (@GetMapping) 구성하시오
    // 접속 테스트 http://localhost:8080/auth/login
    // 1. URL 적용, 메소드(Get|Post|..) 방식과 함께
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    // 5. Post로 전송된 데이터 서버측에서 받기
    // ~/auth/signin
    //    실습 접속확인 -> post 방식으로 요청해야 테스트 가능함, get 요청 -> err 405
    //    전달 데이터 설정 : uid, upw 전달
    @PostMapping("/signin")
    @ResponseBody // html 랜더링이 아닌 텍스트로 응답 처리, 응답 직접 구성
    public String signin(@RequestParam String uid,
                         @RequestParam String upw) {
        // 실제
        // 유효성 검사 -> 디비쿼리(회원이가? 점검) -> 결과에 후속처리(인증..)
        // 임시 로그
        System.out.println("클라이언트 전송 데이터 : " + uid);
        return "signin "+uid+" "+upw;
    }

    // 6. post + url path
    //    ~/auth/signin/75/S909 or ~/auth/signin/50/S901, ... 무한대로 설정가능(url path)
    //    url path => 매일 업데이트되는 데이터가 많다면->화면으로 출력, 보안x 적절!!
    @PostMapping("/signin/{pno}/{pid}")
    @ResponseBody
    public String signin2(@PathVariable String pno,
                          @PathVariable String pid,
                          @RequestParam String uid,
                          @RequestParam String upw) {
        System.out.println("클라이언트 전송 데이터 : " + uid);
        // 잘 전달되었는지 확인용
        return "signin "+uid+" "+upw + " " + pno + " " + pid ;
    }
}
