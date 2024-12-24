package org.example.demoex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  - 글쓰기, 글목록, 글수정, 글삭제 등 url 제공,
 *  - 요청/응답 처리
 */
@RequestMapping("/post") // url prefix 설정
@Controller
public class PostController {
    // ~/post/list, get방식 준비
    @GetMapping("/list")
    public String list() {
        return "test/post_list"; // resources/templates/test/post_list.html 읽어서 랜더링
    }
}
