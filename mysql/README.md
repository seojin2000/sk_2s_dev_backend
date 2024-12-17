# 데이터베이스
- 개발환경 구축
    - 로컬 PC 기반 설치
        - OS에 직접 설치
            - 단점, 업데이트 이슈, PC가 교체되면 다시 설치
            - 인터넷 연결 X 사용가능
            - 상대적으로 빠른 구동!!
        - mysql은 최초는 무료 > oracle 회사에 인수
            - mysql 개발자들이 나와서 만든 DB -> mariadb
            - aws에서 오로라DB -> mysql 엔터프라이즈급 디비 제품 존재
            - 동일한 SQL을 사용
                - SQL = 표준SQL + 벤더별SQL
            - 다운로드 주소
                - https://downloads.mysql.com/archives/installer/

    - (*)Docker 기반 컨테이너 설치
        - 컨테이너 베이스로 설치
        - OS에 영향 X, 삭제, 설치등 원활
        - 리눅스 위에서 작동 -> 일관성 가짐
        - Devops상에서 기본 구동 형태로 사용 
        - 세팅
            - (*)Docker client 설치
            - 명령어에서 mysql 설치 
            - mysql 전용 workbanch 설치(별로도)

        - mysql 설치
            - image 다운로드
                - mysql 이미지 다운로드 (ex) xx.iso파일->CD굽기, usb 설치파일등등등 )
            - image로부터 컨테이너 생성 
                - mysql 이미지 -> 설치
                - 컨테이너 가동 -> mysql 사용!!
            - (*)mysql 이미지/컨테이서 생성
                ```
                    docker run -d -p 3306:3306 --name mysql --env MYSQL_USER=ai --env MYSQL_PASSWORD=1234 --env MYSQL_ROOT_PASSWORD=1234 mysql
                ```
                ```
                    docker run  : 이미지를 다운, 컨테이너 생성,구동
                    -d          : 백그라운드로 가동
                    -p 3306:3306 : OS단에서 3306번으로 접근(포트)
                    --name mysql : 컨테이너 이름
                    --env MYSQL_USER=ai : 환경변수 ai 유저 생성
                    --env MYSQL_PASSWORD=1234  : ai 유저의 비번
                    --env MYSQL_ROOT_PASSWORD=1234 : root 유저의 비번
                    mysql : 이미지 이름
                ```
            - 확인
                - 도커 클라이언트 툴
                - 컨테이너 탭
                - mysql 클릭
                - EXEC 클릭 
                    ```
                        # 접속
                        mysql -u root -p
                        password:1234 <= 비번입력
                        ...

                        mysql> <= 정상 설치및 접근 OK
                    ```

    - Cloud 기반 설치
        - AWS(아마존 클라우드) 기반 RDS 서비스 사용
            - 비용 주의!!
        - AWS 기반 고사양 EC2 직접 설치

    - Client Tool
        - GUI 기반 툴로써, mysql을 손쉽게 엑세스하여 쿼리 수행및 기타 관리를 하는 용도임!!, 디비 본체는 도커내 컨테이너임

        - MySQL Workbench
            - https://dev.mysql.com/downloads/workbench/
        
        - (*)하이디SQL
            - https://www.heidisql.com/download.php
            - 연결 
                - 실행 > 세션관리자 > 신규
                - 호스트 : 127.0.0.1
                - 사용자 : root
                - 비밀번호 : 1234
                - 데이터베이스 : 삼각형 버튼 눌러서 목록이 보이면 접속 성공
                    - 선택 없이 확인 버튼 클릭 > 진입
            - 더미 데이터 다운
                - 자료실(구글)
                    - ~/backend/data/sql_test_db.sql
            - 접속후 화면 
                - File > SQL 파일 실행 > sql_test_db.sql 선택
                - 인코딩 팝업(확인 클릭)
                - F5 : 새로고침 실행
            - 차후 세션관리자에서 데이터베이스 항목 t1으로 변경
        
        - (*)vscode, 인텔리J등 => extention or 기본메뉴
            - mysql 검색후  Weijan cjen 제품(2번째 ) 설치

- 학습 범위
    - (*)SQL
    - 상황보고
        - 모델링
        - (*)ERD

# SQL 구성
- Structured Query Language
    - Database
        - (대량) 데이터를 스키마(구조)에 맞춰서 저장하는 저장소
        - (*)정형, 비정형, 반정형 데이터
        - 개발자는 DB에 질의를 해서 데이터를 획득
            - 비즈니스 로직 처리
                - 아이디/비번 => 조회 => 로그인
                - 검색어 => 검색 => 결과를 출력 : 검색엔진진
    - 질의
        - 구조화된 질의 언어(SQL) 문법 통해 진행
        - 데이터베이스와 대화를 하는 언어

- 구성
    - SQL = (*)DQL + DDL + DCL + DML (or TCL) 
        - DQL : Data Query Language
            - 조회!!, 질의 => 결과셋, 가장많은 분량
            - select
        - 나머지 언어, 진행하면서 정의

# 접속
- 도커 클라이언트 기준
    - 컨테이너 > mysql 클릭 > Execs 클릭
    ```
        mysql -u root -p
        password > 1234 <= 않보임
    ```

# DQL
- 개요
    - 데이터베이스라는 저장소(데이터웨어하우스,...)에서 원하는 데이터를 가져오는 쿼리문
    - 데이터 질의어
    - SQL => 대소문자 구분 x
        - Select or SELECT or select, ...

- 데이터베이스 조회
    - 존재하는 모든 데이터베이스 확인
    ```
        show databases;
    ```
    - 내가 접근한 데이터베이스 존재여부 확인
        - 물리적으로 존재하는가?
        - 내가 로그인한 계정에서 접근 가능한가?

- 특정 데이터베이스 사용 지정
    ```
        use mysql;
    ```

- 지정한 데이터베이스에서 테이블 목록 확인
    ```
        -- 모든 테이블 목록 출력
        show tables;
    ```

- 테이블의 상세 정보 출력
    ```
        - 테이블의 구조(컬럼, 타입, ....) 확인 가능함
        desc user;
        describe user;
    ```

- SELECT - 데이터 조회
    - 가장 많이 사용하는 구문
    - [ .. ] => 생략가능!!
    ```
        SELECT select_expression(조회 결과로 나오는 내용:컬럼,..)
            [FROM table_reference:테이블명]  <= 출처
            [WHERE condition:조건]      <= 데이터 조건, 1차 조건
            [GROUP BY {col_name|expression|posion}] <= 집계/통계
            [HAVING condition:조건]     <= 2차조건
            [ORDER BY 정렬(오름|내림) ]  <= 정렬대상을 여러개 나열가능 (a컬럼 오름, b컬럼 내림)
            [LIMIT [시작], 끝] <= 제한, 게시판(페이징처리)
    ```

- SELECT ~ FROM
    - 특정 테이블로부터 데이터 획득!!
        ```
            -- city라는 테이블에서 => 출처
            -- 모든 데이터를 => 모든(*) 컬럼
            -- 가져(조회)오시오
            -- 문장의 끝 => ; 반드시 붙임
            -- 결과셋 : (4079, 5)
            SELECT *
            FROM city;
            -- * : 사용 가급적 금지!!
            -- 반드시 조건 사용!! -> 모두 가져오기 x
        ```

    - 특정 컬럼만 가져오기
        ```
            -- city 테이블에서 
            -- name, Population 컬럼만 조회하여
            -- 모든 데이터를 가져오시오
            SELECT name, Population
            FROM city;
            -- select_expression 자리에는 컬럼을 순서대로
            -- 나열하면 결과를 원하는대로 가져올수 있다
        ```
    
    - 컬럼명 별칭
        ```
            -- 컬럼의 이름이 너무 길거나, 특정되지 않는다!!
            -- 별칭 -> 결과셋의 컬럼명을 변경
            -- 원본 이름 as 별칭
            -- 컬럼명을 변조 -> 원본 테이블의 컬럼명 노출 방지(긍정)
            SELECT NAME AS nm, 
                    Population AS popu
            FROM city;
        ```

- SELECT ~ FROM ~ WHERE ~
    - 특정 조건을 부여 -> 서브셋만드는 과정
    - 조건이 없다면 -> 모든 데이터, (*)조건이 있다면 -> 해당 데이터
    - 연산자
        - 조건 연산자 : =, >, <, >=, <=, !=, <>
        - 관계(논리) 연산자 : NOT, AND, OR
        - 연산자 조합

    - 조건 적용
        ```
            -- city 테이블에서
            -- 이상,이하 (>=, <=), 초과,미만 (>, <)
            -- 인구수가 5,000,000 이상(>=)이 되는 
            -- 도시를 추출(조회)하시오 -> 모든 컬럼
            -- 테이블명.컬럼명 자동완성됨 -> tool에서 제공
            SELECT *
            FROM city
            WHERE city.Population >= 5000000;
            -- (24r x 5c)

            -- 위의 쿼리문 기반으로 조건 변경
            -- 인구수가 5백만 이상이고(AND),  6백만 이하인 
            -- 도시의 모든 데이터 조회
            SELECT *
            FROM city
            WHERE  city.Population >= 5000000 
                AND city.Population <= 6000000;

            -- 인구수가 5598953이 아닌(!=, <>) 도시의 모든 개수를 구하시오
            -- 개수는 count(*) 함수 사용, 별칭 부여 cnt
            SELECT COUNT(*) AS cnt
            FROM city
            WHERE Population != 5598953;

            SELECT COUNT(*) AS cnt
            FROM city
            WHERE Population <> 5598953;
            -- 전체는 4,079개, 조건부여 4,078개            

            -- city 테이블에서
            -- 국가코드(CountryCode)가 KOR 혹은(OR) USA인 데이터를
            -- 모두 가져오시오
            SELECT *
            FROM city
            WHERE city.CountryCode='KOR' OR CountryCode='USA';

            -- 한국의 도시들중 AND 인구수가 백만이상인 도시 데이터만
            -- 모두 조회하시오
            SELECT *
            FROM city
            WHERE city.CountryCode='KOR' AND city.Population>=1000000;
            -- 0.016초

            SELECT *
            FROM city
            WHERE city.Population>=1000000 AND city.CountryCode='KOR';
            -- 0.000초

            -- 조건식의 배치 순서에 따라 처리 속도가 다름!!
        ```


- SELECT ~ FROM ~ WHERE ~ BETWEEN
    - 조건식에 BETWEEN를 사용
    - 조건을 부여하는 컬럼의 데이터 타입이 수치형(or 연속형)일때 사용가능
        - 값과 값사이가 무한대 : 통상 연속형의 특징을 가짐
        - 컬럼명 BETWEEN a AND b
            - a <= 컬럼값 <= b
        ```
            -- city 테이블에서
            -- 모든데이터를 가져온다
            -- 단, 인구수가 5백만이상, 6백만 이하인 도시만 해당된다
            -- 5000000 <= 인구수 <= 6000000
            SELECT *
            FROM city
            WHERE city.Population BETWEEN 5000000 AND 6000000;
        ```

- SELECT ~ FROM ~ WHERE ~ IN
    - 대상 컬럼의 데이터가 명목형(범위 부여 불가능) 데이터 대상
    - 직접 나열한 대상만 조건이 되는 방식
    ```
        -- 한국(KOR), 미국(USA), 일본(JPN), 프랑스(FRA) 도시를대상
        -- 모든 데이터 총 수를 구하시오, 별칭은 cnt
        SELECT COUNT(*) AS cnt
        FROM city
        WHERE city.CountryCode IN ('KOR','USA','JPN','FRA');
        -- 632


        -- 한국(KOR), 미국(USA), 일본(JPN), 프랑스(FRA) 도시를대상
        -- 이중 인구수가 6백만 이상(>=)인 도시 => AND로 연결
        -- 도시명, 인구수만 출력하시오
        SELECT `NAME`, Population
        FROM city
        WHERE  city.CountryCode IN ('KOR','USA','JPN','FRA')
            AND city.Population >= 6000000;
        -- 3

    ```

- sub query
    - 서브 쿼리
    - 쿼리문(결과셋) 안에 쿼리문(결과셋)이 존재
        - 대상
            - 특정 테이블이 대상이 아니라, 테이블의 조회가 결과가 일종의 대상이 됨
        - 조건
            - 테이블의 조회결과가 조건에 사용된다

    ```
        -- 프랑스에 존재하는 모든 도시 정보를 출력하시오
        -- 조건- 국가 코드를 모른다!!
        -- paris라는 도시명은 알고 있다!!
        -- 해결 => paris를 이용하여 프랑스 국가코드를 획득 
        --      => 위의 결과를 이용하여 <-'프랑스' <-'모든 도시 정보 획득'
        -- (서브 쿼리->결과값 1개인가(where) n개 인가(from)?)
        SELECT *
        FROM city
        WHERE city.CountryCode=( 	SELECT CountryCode
                                            FROM city
                                            WHERE `NAME`='paris'
                                        );
        -- 서브쿼리 결과 FRA -> 1개의 결과

        -- 동일 요구사항, 단 District 컬럼값에 'New York'를 이용하여 구성
        -- 주 정보를 이용하여 국가코드 획득 -> 해당국가의 모든 도시 정보 획득
        SELECT *
        FROM city
        WHERE city.CountryCode=( 	SELECT CountryCode
                                            FROM city
                                            WHERE District='New York'
                                        );
        -- 오류발생, 1개의 일치된 값을 요구하는 조건문에 N개의 값을 대입
        -- 해결 : 서브쿼리 조정-> 결과가 1개만 나오게 처리 (의도는 아님)
        -- 다른 방식 : ANY, SOME을 응용하여 처리가능

        -- 서브쿼리를 FROM에 사용 -> n개의 결과셋을 대상으로 진행
        -- 통상 별칭 부여 -> 결과셋의 이름부여
        -- 컬럼을 나열할때 이름.컬럼명 표현하여 출처를 명확하게 명시
        -- 최종 컬럼명 별칭.컬럼명
        SELECT A.*
        FROM (SELECT CountryCode, `NAME` AS city_nm
                FROM city
                WHERE District='New York') AS A
    ```
    - 대부분의 요구사항들 대상, 디테일한 sql을 모른다면 => 서브쿼리로 모두 해결 가능하다!!


- ANY, SOME
    - 서브쿼리의 결과가 여러개가 나왔다, 조건식에서 사용하고 싶다
    - 한가지만 만족하면 사용가능하게 처리

    ```
        -- 뉴욕`주`인 데이터 대상으로 인구를 구한다
        -- 해당 인구보다 크기만 하면, 특정 대상이 되어, 
        -- 모든 도시 정보를 출력한다

        -- 모든 데이터들중에 뉴욕`주`에 해당되는 인구수보다 크면 조회된다
        SELECT *
        FROM city
        WHERE Population > ( SELECT Population
                                    FROM city
                                    WHERE District='New York'
                                );

        -- ANY 적용
        SELECT *
        FROM city
        WHERE Population > ANY ( SELECT Population
                                    FROM city
                                    WHERE District='New York'
                                );
        -- 3782

        SELECT *
        FROM city
        WHERE Population > SOME ( SELECT Population
                                    FROM city
                                    WHERE District='New York'
                                );
        -- 3782
        -- 결론:뉴욕주의 가장 작인 인구수를 가진 도시보다 크기만 하면 모두 대상이됨


        -- IN 하고 같은 결과물
        SELECT *
        FROM city
        WHERE Population = ANY ( SELECT Population
                                    FROM city
                                    WHERE District='New York'
                                );
    ```

- ALL
    - 서브 쿼리의 모든 결과를 만족하면 조회된다
    ```
        -- ALL
        -- 서브 쿼리의 결과 셋과 다 비교하여 모두 만족할때 대상이 됨
        -- 가장 큰값보다 크면 모두 해당됨!!
        SELECT *
        FROM city
        WHERE Population > ALL ( SELECT Population
                                    FROM city
                                    WHERE District='New York'
                                );
    ```