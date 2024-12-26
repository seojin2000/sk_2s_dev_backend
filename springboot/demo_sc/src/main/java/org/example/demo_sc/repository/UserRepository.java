package org.example.demo_sc.repository;

import org.example.demo_sc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 회원 관련 SQL 지원
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
