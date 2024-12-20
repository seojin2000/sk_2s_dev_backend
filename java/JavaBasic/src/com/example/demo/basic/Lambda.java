package com.example.demo.basic;

/**
 * 자바의 람다 표현식
 *      - 자바 8에서 도입
 *      - 익명함수 형태로 간결하게 표현
 *      - JS의 화살표 함수와 유사함
 *          - JS : ()=>{}
 *          - Java : ->
 *      - 함수형 프로로그래밍 패러타임 지원
 */
public class Lambda {
    public static void main(String[] args) {
        // 순수한 코드 => 람다 처리
        // 1. 쓰레드에서 사용
        {
            // 쓰레드(Thread) : 자바의 작업 단위, 프로세스 =  쓰레드 + 쓰레드 + ...
            // 용도 : 멀티 작업을 구현 하기 위해서 도입 (멀티 쓰레드 기본)
            // 쓰레드 가동법
            // 1. Runnable 인터페이스를 객체처럼 생성 -> 쓰레드객체에 넣어서 가동, run() 메소드
            //    실제 일하는 요소 : run()
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    // 실제 일하는 내용 작성
                    System.out.println("T - Hello World");
                }
            };
            // 2. 쓰레드 가동
            new Thread(r).start();
            // 스프링부트에서는 미사용됨

            // 람다로 수정
            Runnable r2 = ()->System.out.println("T2 - Hello World");
            new Thread(r2).start();

            // 더줄임
            new Thread( ()->System.out.println("T3 - Hello World") ).start();
        }
    }
}
