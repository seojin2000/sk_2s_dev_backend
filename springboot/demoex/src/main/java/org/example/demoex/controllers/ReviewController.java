package org.example.demoex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/review")
@Controller
public class ReviewController {
    @GetMapping("/list")
    public String list() {
        return "list";
    }
    @GetMapping("/create")
    public String create() {
        return "create";
    }
    @GetMapping("/modify/{id}")
    public String modify() {
        return "board/review_form";
    }
    @GetMapping("/delete/{id}")
    public String delete() {
        return "delete";
    }
}
