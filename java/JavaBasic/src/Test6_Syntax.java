/**
 * 변수 문법
 * - [Modifiers] Type 변수
 *      - [] 생략가능
 * - Modifiers => 사용 목적이 존재할때만 사용
 *      - access Modifiers : 접근제어자
 *      - non-access|gerneral Modifiers :일반
 *      - 2가지는 혼용 사용가능, 서열 x
 * - Type
 *      - 원시타입 (8개)
 *      - 참조타입
 * - 변수명
 *      - 카멜표기법
 *          - 소문자로 시작, 이어지는 글자 대문자, 다시 소문자..
 *          - 알파벳시작, _ 시작가능 , 두번쩨문자부터 숫자 가능
 *          - 알파벳만 사용!! (간단)
 */
public class Test6_Syntax {
    // 전역 변수 자리 (범위 기준)
    // public : 모든 다른 클레스, 내부등등 다 접근 가능하다
    // static : 메모리 탑레벨, static 메소드에서만 사용 가능
    // 정수형 그릇에 100이라는 값이 세팅되었다 => 힙에 메모리 존재한다(참고)
    public static int score = 100;
    static public int score1 = 100;
    public int score2 = 100;
    static int score3 = 100;

    // 최소, 가장 기본형
    int age = 100; // js => let age = 100;

    // 메소드
    public static void main(String[] args) {
        // 지역 변수 자리(범위 기준)
        // 가장 많이 사용하는 유형
        int level = 5;// static 아닌데 가능한데? -> 지역이니까 사용가능!!
        System.out.println(level);
        System.out.println(score);
        System.out.println(score1);
        System.out.println(score3);
        // 메소드가 satic 이라서
        //System.out.println(score2); // non-static 사용 불가, 에러
    }
}
