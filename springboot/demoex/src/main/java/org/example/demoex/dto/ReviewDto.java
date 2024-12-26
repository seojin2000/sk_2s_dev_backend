package org.example.demoex.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.demoex.entities.Post;
import org.example.demoex.entities.Review;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder
public class ReviewDto {
    // 실습 :  진행 내부 구성, Review 엔티티 대상으로 수행
    private int id;
    private String content;
    private LocalDateTime createDate;
    private Post post;
    public Review toEntity() {
        return Review.builder()
                .id(id)
                .content(content)
                .createDate(createDate)
                .post(post)
                .build();
    }
}
