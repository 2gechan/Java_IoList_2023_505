 -- iolist USER 화면
 
 -- 현재 설치된 Oracle DBMS 에 포함된 모든 Table 을 보여달라
 select * from all_tables;
 -- IOLIST user 가 접근(CURD)할 수 있는 Table 을 보여달라
 select * from all_tables where owner = 'IOLIST';
 
 -- tbl_product Table 의 속성(Domain)을 보du달라
 -- DBMS 에서 Domain : table 의 속성(칼럼)의 데이터 type
 DESCRIBE tbl_product;
 
 insert into tbl_buyer (buid, buname, butel, buaddr) 
 values ('0000000001', '홍길동', '010-1111-1111', '서울특별시');
 
 insert into tbl_buyer (buid, buname, butel, buaddr) 
 values ('0000000002', '성춘향', '010-2222-2222', '전라북도 남원시');
 
 insert into tbl_buyer (buid, buname, butel, buaddr) 
 values ('0000000003', '이몽룡', '010-3333-3333', '광주광역시');
 
 insert into tbl_buyer (buid, buname, butel, buaddr) 
 values ('0000000004', '이길용', '010-4444-4444', '부산광역시');
 
 commit;
 
 select * from tbl_buyer;
 
 -- PK 를 기준으로 조회(SELECT) 하면 결과는 1개 이거나 null 이다.
 select * from tbl_buyer where buid = '0000000001';
 select * from tbl_buyer where buid = '0000000007';
 
 -- PK 이외의 컬럼을 기준으로 조회하면 비록 1개의 결과만 보일지라도
 -- 이 결과는 1개 이상인 것으로 본다.
 -- 이 결과는 empty 이거나 1개 이상이다.
 select * from tbl_buyer where buname = '홍길동';
 
 /*
 중간문자열 검색
 Full text Search : 칼럼의 데이터의 문자열을 모두 검색하여 일치하는 데이터 찾기
 SELECT 조회 명령 실행 과정에서 가장 느린 Query
 
 칼럼의 데이터 중에 일부라도 일치하는 문자열이 있는 데이터 조회하기
 */
 
 -- 이름 중간 문자열 검색
 -- 홍 이라는 문자열로 시작되는 모든 이름
 -- 첫글자가 홍 인 이름들
 select * from tbl_buyer where buname like '홍%';
 
 -- 동 이라는 문자열로 끝나는 모든 이름
 -- 끝 글자가 동 인 이름들
 select * from tbl_buyer where buname like '%향';
 
 -- 길 이라는 문자열이 포함된 모든 이름
 -- 시작글자, 끝글자, 중간글자 상관없이 길 이라는 문자열이 포함된 모든 이름
 select * from tbl_buyer where buname like '%길%';
 
 -- 연결된 문자열 생성하기
 select '강' || '가' || '딘' from dual;
 
 /*
 표준 SQL 에서는 아주 단순한 연산을 수행하는 select 문을 지원한다.
 숫자의 4칙 ㄱ연산, 문자열 연결하기 등 간단히 select 명령을 통하여
 결과를 확인할 수 있다.
 
 그런데, Oracle 에서는 FROM(FROM 절) 키워드가 생략된 SELECT 명령을
 허용하지 않는다.
 그래서 의미없는 DUMMY Table 을 하나 마련해 두었다.
 Oracle 에서 단순 연산을 위한 SELECT 에서는 dual table 을 사용하여 수행
 */
 select 30 + 40; -- 표준 SQL 문법
 select * from dual;
 
 -- 사칙연산
 select 30 + 40 from dual;
 select 30 - 40 from dual;
 select 30 * 40 from dual;
 select 30 / 40 from dual;
 
 -- 연산
 select 30 + 40 + 50 + 60 from dual;
 
 -- 함수를 사용한 연산
 -- 테이블에 데이터가 몇개 있느냐?
 select count(*) from tbl_buyer;
 
 -- 이름에 길 문자열이 포함된 고객이 몇명이냐
 select count(*) from tbl_buyer where buname like '%길%';
 
 -- 현재 저장된 데이터 중에서 가장 큰 buid 값은 얼마냐
 select max(buid) from tbl_buyer;
 
 select min(buid) from tbl_buyer;
 
 update tbl_buyer set
 buName	= buName,
 buTel	= buTel,
 buAddr	= buAddr
 where buId	= buId;
