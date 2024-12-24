package org.example.demoex.controllers;

import org.example.demoex.dto.PostDto;
import org.example.demoex.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *  - 글쓰기, 글목록, 글수정, 글삭제 등 url 제공,
 *  - 요청/응답 처리
 */
@RequestMapping("/post") // url prefix 설정
@Controller
public class PostController {
    // (* 매우 중요)DI 구성 3가지 방식(@Autowired 사용, 생성자 함수활용, setter 활용)
    @Autowired
    private PostService postService; // 서비스 객체를 가져와서

    // ~/post/list, get방식 준비
    @GetMapping("/list")
    public String list(Model model) {
        // 1. 서비스(PostService)를 통해서 쿼리가 실행이 되고(내부적), 그 결과를 가져온다
        //    서비스 객체를 가져와서 -> 매번 가져온다? -> 객체가 매번 생성된다? -> n개
        //    (*)객체가 한번만 만들어지고 => 요청할때 마다 그 객체가 와서 작업되어 진다면?->1개
        //    싱글톤 디자인 패턴!! 어떻게 제공할것인가? -> SB에서는 DI(의존성 주입) 개념 도입 -> 해결
        //  postService.xxxx() 바로 사용 가능(이미 객체는 만들어져 있다)

        // 서비스의 findAllPost() 메소드를 호출해서, 모든 게시물을 가져와서 DTO에 교환해서 받을것이다!!
        // DTO 생성
        List<PostDto> posts = postService.getAllPost(); // 모든 post의 내용 가져오기
        // 디비에서 가져온 데이터 확인
        for (PostDto post : posts) {
            System.out.println(post.toString());
        }
        // 2. 조회 결과는 타임리프 템플릿 엔진에 전달하여, 동적으로 html 구성 한다(랜더링)
        //    Model 객체를 활용하여 데이터를 세팅후 전달한다
        //    1. 매개변수에 모델 객체 추가
        //    2. 코드 내부에서 모델 객체에 데이터 추가
        model.addAttribute("posts", posts); // 게시물 데이터 전달
        model.addAttribute("dummy", "hello"); // 더미

        // 3. 응답한다
        return "board/post_list"; // resources/templates/test/post_list.html 읽어서 랜더링
    }

    @GetMapping("/create")
    public String create() {
        return "board/post_form";
    }
    @GetMapping("/detail/{id}")
    public String detail() {
        return "board/post_detail";
    }
    @GetMapping("/modify/{id}")
    public String modify() {
        return "board/post_form";
    }
    @GetMapping("/delete/{id}")
    public String delete() {
        return "delete";
    }

}
