package com.example.demo.basic;

/**
 * 인터페이스
 *  - 자바는 단일 상속 지원!!
 *  - 다중 상속 이슈 -> 인터페이스가 제공
 *  - 구현한다!! (implements)
 *  - 구성원
 *      - 상수
 *      - 추상(abstract) 메소드 : 메소드 문법중 {}:코드블럭  x => 메소드 선언만 존재
 *      - java 8에서 추가 : 기본 메소드
 *  - 문법
 *    interface 인터페이스명 {
 *        [상수]
 *        [추상 메소드]
 *        [기본 메소드]
 *    }
 */

/**
 * final : 최종이라는 의미를 가진 키워드
 *  - 변수에서 사용 : 상수
 *  - 메소드에서 사용 : 재정의 x
 *  - 클레스에서 사용 : 상속을 해주는것 불가
 */
interface Vehicle {
    // 상수 => final
    public static final int MAX_VEHICLES = 5;
    String NAME = "내연"; // public static final 생략된 표현, 컴파일러 자동 삽입
    // 인터페이스에서는 생략 가능 : public static final
    // 메소드 선언 => 코드 블럭 생략!!
    void start();
    void stop();
}
// 인터페이스 사용
class Car implements Vehicle {
    // 인터페이스를 구현 => 선언된 함수를 구현해랴 한다!! 의무!!
    // ctrl + i , code -> implements ...
    @Override
    public void start() {
        // 적당한 메세지 각자 작성 => 콘솔 출력
    }
    @Override
    public void stop() {
    }
}
class Truck implements Vehicle {
    @Override
    public void start() {
    }
    @Override
    public void stop() {
    }
}

public class Interface {
    public static void main(String[] args) {

    }
}
