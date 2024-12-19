/**
 * 흐름제어
 *  - 조건문 : if ~ else if ~ else ~
 *      - 콘솔 입력 사용
 *  - 반복문 : for ~,  do ~ while, while ~ , continue, break
 *  - 게임 제작(간단하게)
 *      - 콘솔 입력 사용
 */
public class Test3 {
    public static void main(String[] args) {
        // 조건문 연습
        flowcontrol1();
        // 반복문 연습
        flowcontrol2();
    }

    private static void flowcontrol2() {
        // for 문의 문법 => JS와 유사함
        // 기본 for문
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        // 응용
        // 1 ~ 100까지 총합계 구하시오 => 기본 for문 사용
        int sum = 0; // 합계값을 담을 그릇(정수형)
        for (int i = 1; i <= 100; i++) {
            // 누적합
            sum += i;
            //sum = sum + i;
        }
        System.out.println("누적합 : " + sum);

        // 역순 출력
        // 값 업데이트 파트  => i++, i--, i+=2, ... 여러 표현 가능(요구사항에 맞게)
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
        }

        // 배열 순환 for
        int[] arr = {3, 7, 4, 10};
        // arr.length : 배열의 길이, 현재 데이터 기준 4번 반복
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 중첩 for문 => 구구단 => 5~7단, 3~6까지만 출력
        // 출력값 : 5 x 3 = 15, .... 7 x 6 = 42
        // 15, .... 42 <= 곱의 결과만 나오게 출력
        for (int i = 5; i <=7; i++) {     // i : 5, 6, 7
            for (int j = 3; j < 7; j++) { // j : 3, 4, 6
                // print() 줄바꿈 없는 출력
                System.out.print( i*j + "\t" );
            }
        }
        // 피라미드 출력 연습
        // 오후 학습 정리때 시도 !! => 2중(중첩) for문 처리
        /*
               *
              ***
             *****
            *******
           *********
         */

        // for-each 반복 처리

    }

    private static void flowcontrol1() {
        // 1. 콘솔 입력
        //Scanner sc = new Scanner(System.in); // 콘솔에서 사용자 입력 대기하는 코드
        //while(true)
        {
            System.out.println("Enter number: ");
            // 2. 사용자 입력후 엔터 => 값이 반환
            int userInputValue = 10;// sc.nextInt(); // 입력 대기
            // 3. 만약 100을 입렷했다면, 종료 혹은 반복문 탈출
            //if (userInputValue == 100) break;
            // 4. 조건식 사용, JS 조건문 동일, 조건이 2개? 3개?
            if (userInputValue > 10) {
                System.out.println("10보다 초과한다");
            }else{
                System.out.println("10보다 작거나 같다");
            }
        }
        // 입력 닫기
        //sc.close();
    }
}
