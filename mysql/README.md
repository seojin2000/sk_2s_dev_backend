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

    - Cloud 기반 설치
        - AWS(아마존 클라우드) 기반 RDS 서비스 사용
            - 비용 주의!!
        - AWS 기반 고사양 EC2 직접 설치

    - MySQL Workbench
        - https://dev.mysql.com/downloads/workbench/

- 학습 범위
    - (*)SQL
    - 상황보고
        - 모델링
        - (*)ERD