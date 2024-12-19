import java.util.Scanner;

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
    }
    private static void flowcontrol1() {
        // 1. 콘솔 입력
        Scanner sc = new Scanner(System.in); // 콘솔에서 사용자 입력 대기하는 코드
        while(true) {
            // 2. 사용자 입력후 엔터 => 값이 반환
            int userInputValue = sc.nextInt();
            // 3. 만약 100을 입렷했다면, 종료 혹은 반복문 탈출
            if (userInputValue == 100) break;
        }
    }
}
