package org.example.demoex.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.demoex.entities.Post;
import org.example.demoex.entities.Review;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 데이터 교환용, Post 엔티티의 데이터를 가져와서 컨트로럴에서 사용됨
 * - 테이블과 직접 연결성 X -> 보안에 우수
 * - 구성 :
 *  - 1. Post(타겟 엔티티)의 필드를 모두 복사하여 필드(맴버변수)만 표시함
 *  - 2. 롬복 처리
 *      @Setter
 *      @Getter
 *      @ToString
 *      @Builder
 *  - 3. 엔티티 변환 처리 가능함 메소드 구성 -> toEntity()
 */
@Setter
@Getter
@ToString
@Builder
public class PostDto {
    private int id;
    private String subject;
    private String content;
    private LocalDateTime createDate;
    private List<Review> reviews;

    public Post toEntity() {
        return 
    }
}
