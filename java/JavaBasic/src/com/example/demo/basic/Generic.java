package com.example.demo.basic;

/**
 * 제네릭(Generic)
 *  - <>
 *  - 컬렉션에 자주 등장!!
 *  - 클레스, 메소드, 인터페이스, 변수 사용가능
 *  - 범용성 대변하기 위해 생성된 문법
 *  - 메소드 1개 -> 정수 처리 OK, 부동소수 처리 OK, 문자열 처리 OK
 *      - 만능의 기능을 가진 메소드
 *      - 개념이 없다면, 각가 개별 메소드를 만들어야 한다!!
 *          - 목표:1개만 만들어서 모든 상황에 대응할수 잇다면 !!
 *          - 제네릭을 이용하여 이 개념(요구사항) 구현
 *  - 범용표현
 *      - <T>
 *  - 제약표현
 *      - <String>, <Integer> ....
 */
// 제네릭 표현을 클레스에 적용
// T : 모든 타입이 올수 있다!!
class Multi<T> {
    private T t;
    // getter/setter 자동 생성 : alt + insert -> getter and setter 선택
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}

public class Generic {
    public static void main(String[] args) {
        // 범용 타입으로 정의된 Multi 클레스 사용
        Multi<String> m = new Multi<String>();
        m.setT("Hello");
        System.out.println(m.getT());
        // 정수형을 다루는 Multi  생성
        Multi<Integer> m2 = new Multi<Integer>();
        m2.setT(1);
        System.out.println(m2.getT());
        // 정리 <T>를 도입함으로써 1개의 클레스로 개별 타입의 클레스 대응할수 있었음
    }
}
