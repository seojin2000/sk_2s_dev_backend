package org.example.demoex.controllers;

import lombok.RequiredArgsConstructor;
import org.example.demoex.dto.PostDto;
import org.example.demoex.services.PostService;
import org.example.demoex.services.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/review")
@RequiredArgsConstructor // DI를 위한 준비
@Controller
public class ReviewController {
    // DI (의존성 주입, 1개의 유일한 객체를 삽입하여 사용가능하게 처리)
    // 세팅법, @Autowired, (*)생성자 방식, setter 방식
    private final PostService postService;
    private final ReviewService reviewService;

    @GetMapping("/list")
    public String list() {
        return "list";
    }
    // 리뷰 등록 -> 특정글에 대한 리뷰,댓글 작성( 1:N 관계 )
    // POst 방식 변경, 검증폼 사용 x
    @PostMapping("/create/{id}")
    public String create(@PathVariable Integer id,
                         @RequestParam String content) {
        // id : 본글 고유 번호(PK)
        // content : 리뷰/댓글 내용
        // 1. id를 기반으로 PostDto 획득
        PostDto postDto = this.postService.getOnePost( id );

        // 2. PostDto, 리뷰 내용등을 가지고, 서비스(ReviewService)로 이동 리뷰 등록 처리


        // 3. 원래 본글의 상세 보기 화면으로 포워딩
        return "redirect:/post/detail/" + id;
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
