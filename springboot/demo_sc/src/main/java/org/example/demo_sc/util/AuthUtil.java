package org.example.demo_sc.util;

import org.springframework.stereotype.Component;

/**
 * 인증 정보, 권한 정보등등 체크하는등 기능을 가진 메소드 제공
 *  - 어떤 클레스에서든 싱글톤 작동하길 원함 -> 의존성 주입 가능하게 구성
 *  - -> @Component 로 정의 -> 스프링부트 관리자가 빈으로 관리하게 구성
 */
@Component
public class AuthUtil {
    // 서브에 구성하는 메소드 -> DI선언후, 메소드 사용
}
