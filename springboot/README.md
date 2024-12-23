# 스프링부트
    - 사전 지식
        - 웹에 대한 간단한 이해/사용
        - 자바 사용 간단하게라도 이해하면 가능
        - 디비 사용 간단하게라도 이해하면 가능
        - html/css/js 로 화면 구성되는것 간단하게라도 이해하면 가능
    - 프로젝트 간단하게 생성하기        
        - hello world 출력
        - 프로젝트 생성
            - 햄버거 > project > springboot 선택
            - 기본 입력값 유지 > 프로젝트 위치만 조정 (~/backend/springboot)
            - next 클릭
            - springboot dev tool, lombok, spring web 선택(체크)
            - next or create 클릭
            - 프로젝트 생성됨
        - 서비스 생성
            - src/main/java/com.example.demo 밑에서 우클릭 > new > class > HomeController 엔터
            ```
                import org.springframework.stereotype.Controller;
                import org.springframework.web.bind.annotation.GetMapping;
                import org.springframework.web.bind.annotation.ResponseBody;

                // http://localhost:8080 접속
                @Controller
                public class HomeController {
                    @GetMapping("/")
                    @ResponseBody
                    public String home() {
                        return "hello world 스프링부트";
                    }
                }

            ```
        - 실행
        - 브라우저 접속
            - http://localhost:8080

    - 목적 
        - 웹서비스 구현 => 클라이언트에게 서비스 제공
            - 쿠팡, 네이버, 뱅킹, 노션, 주식, 블로그, ... 

# 개요
    - 백엔드 구성
        - 유사 제품 : (*)Springboot, .net, nodejs, django/flask/(*)fastapi, php,...
        - 언어를 중심으로 분류됨
    - 프레임웍 vs 라이브러리 
        - 프레임웍은 해당 제품의 `룰`(구조, 규칙)에 따라 코드가 작성되어야 한다
        - 라이브러리는 내가 작성한 코드에 사용(적용), 나의 룰에 따라 작성된다, 단 사용법은 있음
    - 스프링부트
        - 웹서비스를 쉽고 빠르게 개발하기 위해 자바 언어를 이용하여 만든 프레임웍이다
        - 필요한 대부분의 기능들은 라이브러리로 제공
            - 프로젝트 구성시 쇼핑하듯이 필요한 제품 선택 : 데브툴, 롬복, jpa, 타임리프, h2, web.....
            - 나중에 추가 가능
    - 스프링부트(프레임웍) 구조
        ```
        .
        ├── HELP.md
        ├── build                               : 개발(*.class, 리소스), 배포(*.jar|war) 생성됨
        ├── (*)build.gradle                        : 사용 라이브러리 기술/편집, 빌드 정보(JDK, 이름등)
        ├── gradle
        │   └── wrapper
        │       ├── gradle-wrapper.jar
        │       └── gradle-wrapper.properties
        ├── gradlew                     : 빌드 명령어 기술되어 있음 -> CI/CD 할때 체크(세션2), 맥/리눅스용
        ├── gradlew.bat                 : 빌드 명령어 기술되어 있음 -> CI/CD 할때 체크(세션2), 윈도우용
        ├── settings.gradle
        └── (*)src
            ├── main                    : 개발 코드
            │   ├── java
            │   │   └── org
            │   │       └── example
            │   │           └── demoex
            │   │               ├── DemoexApplication.java
            │   │               └── controllers
            │   │                   └── HomeController.java
            │   └── resources           : 리소스, html/css/js or 리액트포함시킬경우, 이미지, 환경변수파일
            │       ├── application.properties  : 환경변수파일 (application.properties|yaml)
            │       ├── static          : 정적데이터 위치 (css, js, 이미지등등)
            │       └── templates       : html 파일 위치, 타임리프(템플릿엔진)가 기본으로 인식하는 위치임
            │           └── index.html
            └── test                    : 단위테스트 진행시,TDD(테스트 주도 개발방법론),CI/CD 중요하게사용
                └── java
                    └── org
                        └── example
                            └── demoex
                                └── DemoexApplicationTests.java
        ```

# 라이브러리 추가
    - build.gradle > dependencies 에 추가
        - 검색 : https://mvnrepository.com/