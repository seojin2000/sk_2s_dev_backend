package org.example.demo_sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 홈페이지, 인증후에만 접근 가능
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
