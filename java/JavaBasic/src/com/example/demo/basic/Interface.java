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
        System.out.println("Car start");
    }
    @Override
    public void stop() {
        System.out.println("Car stop");
    }
}
class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println("Truck start");
    }
    @Override
    public void stop() {
        System.out.println("Truck stop");
    }
}

// 2. 멀티의 인터페이스 구현
interface A{
    void a();
}
interface B{
    void b();
}
class P{}
// 클레스 C는 P이고, A이면서 B이기도 하다 => 다중상속
class C extends P implements A,B{
    @Override
    public void a() {
    }
    @Override
    public void b() {
    }
}

public class Interface {
    public static void main(String[] args) {
        // 인터페이스를 이용한 다형성  처리
        Vehicle vehicle;
        vehicle = new Car(); // 인터페이스 변수에 구현한 객체를 받아서 객체처럼 사용 가능
        vehicle.start(); 
        vehicle.stop();
        vehicle = new Truck();
        vehicle.start();
        vehicle.stop();

        // 멀티 인터페이스 구현, 단일 상속 => 다중 상속 구현
        C c = new C();
        c.a();
    }
}
