import java.util.ArrayList;
import java.util.List;

/**
 * 컬렉션(*) API
 *      - 데이터베이스 연동후 가져오는 데이터는 => 컬렉션 으로 처리됨!!
 *      - 맴버를 언제든지 추가 삭제 가능함
 *      - List
 *          - 순서가 있다
 *          - (*)ArrayList, LinkedList, ...
 *      - Set
 *          - 중복 데이터가 없다(중복제거)
 *          - HashSet, TreeSet
 *      - Map
 *          - 키와 값 형태로 보관 -> JSON, JS 객체 , python dict
 *          - HashMap, TreeMap
 */
public class Test5 {
    public static void main(String[] args) {
        // 1.  (중요)List, 순서(*) 존재->인덱스(0, 1, ..) 존재!!, 중복 가능함
        {
            // 저장 공간 준비
            // <유형> =>  제네릭 표현 (범용성등 목적)
            // ArrayList : 자식, List: 부모
            // 크기 지정 한적 없다!!
            List<String> temp = new ArrayList<>();    // new 클레스명() => 객체 생성
            System.out.println(temp); // []

            // 더미데이터 사용 <- 가변크기, 언제든지 맴버를 추가할수 있다!!
            temp.add("a");
            temp.add("b");
            temp.add("c");

            System.out.println(temp); // [a, b, c]

            // List 언제든지 가변적으로 맴버 추가 혹은 삭제 가능
            // 값 출력하기
            System.out.println( temp.get( 1 ) ); // 참고 배열은 변수[ 1 ]
            // 크기 확인 -> for문과 자주 사용
            System.out.println( temp.size() ); // 데이터 전체 크기
            // 요소 삭제
            System.out.println( temp.remove(1) ); // 삭제된 내용이 출력
            // 초기화 -> 데이터 모두 버림 -> 버퍼를 비운다, 모두 삭제
            temp.clear();
            System.out.println( temp.size() );
            System.out.println( temp );
        }
    }
}
