package org.example.demoex.repositories;

import org.example.demoex.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 레포지토리,
 *  - SQL 담당
 *  - 많은 CRUD등 많은 쿼리들이 메소드로 준비되어 있음
 *  - 패턴에 따라 생성 가능
 *  - 직접 SQL 사용 가능
 */
public interface PostRepository extends JpaRepository<Post, Integer> {
}
