package org.example.demoex.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Review {
    // 컬럼 나열
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // 본글 : 리뷰 = 1 : N 관계
    // 리뷰 : 본글  = N : 1 관계
    @ManyToOne
    private Post post;
}
