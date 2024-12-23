package org.example.demoex.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 본글에 대한 엔티티, post 테이블 대변
 */
@Getter
@Setter
@Entity
public class Post {
    // 컬럼
    @Id
    // auto_increment, 자동 부여, 자동 증가, 중복 x
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 크기를 커스텀 설정
    @Column(length = 256)
    private String subject;

    // 65536 크기 입력 가능
    @Column(columnDefinition = "TEXT")
    private String content;

    // 커스텀 컬럼 생략
    private LocalDateTime createDate;

    // 본글 : 리뷰 = 1 : N
    // mappedBy => FK 컬럼명
    // cascade = CascadeType.REMOVE => 본글 삭제되면 관계된 리뷰 모두 삭제
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Review> reviews;
}
