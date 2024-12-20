package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8080 접속
@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "hello world 스프링부트";
    }
}
