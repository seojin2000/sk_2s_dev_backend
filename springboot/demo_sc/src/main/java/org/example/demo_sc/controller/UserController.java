package org.example.demo_sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * - 인증없이 접근가능함 : 로그인, 회원가입
 * - 인증후에 접근가능함 : 로그아웃 (필요시 컨트롤러 분리 가능함)
 */
@Controller
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
