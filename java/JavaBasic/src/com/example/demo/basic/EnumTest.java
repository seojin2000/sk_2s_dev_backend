package com.example.demo.basic;

/**
 * 열거형
 *  - 상수로 정의되는 여러 변수들을 묶어서 클레스처럼 관리하는 타입
 *  - 여러 상수를 그룹으로 묶어서 관리!!
 *  - 내부적인 변수들은 모두 public static final  적용됨
 */
// 1. 기본형
enum Level {
    VVIP, VIP, GOLD, SILVER, BRONZE // 고객 등급
}
public class EnumTest {
    public static void main(String[] args) {
        // 1. 기본 사용
        {
            // 열거형 타입의 변수
            Level level = Level.VVIP; // 값은 5개중에 한개만 가능
            // 등급값에 따라 동적으로 처리가 가능한 구조!!
            switch (level) {
                case VVIP:
                    System.out.println("VVIP");
                    break;
                case VIP:
                    System.out.println("VIP");
                    break;
                default:
                    System.out.println("기타 등급");
                    break;
            }
        }
    }
}
