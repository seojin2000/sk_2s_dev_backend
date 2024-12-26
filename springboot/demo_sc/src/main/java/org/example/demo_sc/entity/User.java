package org.example.demo_sc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 테이블과 1일 1로 연결된 클레스, 1개 객체는 데이터 1개와 연동
 */
@Table(name="userTbl") // 엔티티의 이름과 실제 테이블명을 다르게 하고 싶다면
@Setter
@Getter
@Entity
// 인증관련 UserDetails을 적용 => 스프링시큐리티 정책
public class User extends UserDetails {
    // 단수하게 정리 : Long id,  String email, String password(암호화)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false) // name="변경됨 컬럼명"
    private String email;

    @Column(nullable = false)
    private String password;

    // 6개의 추상 메소드를 추상클레스(UserDetails) 를 상속 받으면서 재정의 해야한다!! -> 룰
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
