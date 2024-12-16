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

    - Cloud 기반 설치
        - AWS(아마존 클라우드) 기반 RDS 서비스 사용
            - 비용 주의!!
        - AWS 기반 고사양 EC2 직접 설치

    - MySQL Workbench
        - 

- 학습 범위
    - (*)SQL
    - 상황보고
        - 모델링
        - (*)ERD