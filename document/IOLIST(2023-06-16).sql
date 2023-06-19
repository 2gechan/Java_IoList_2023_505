 -- IoList DBA 화면
 /*
 Project 에 필요한 Table 을 생성하고
 SEQUENCE 등을 생성한다
 
 CRUD 코드를 테스트 한다.
 */
 
 -- 상품정보 테이블 생성
 create table tbl_product (
    pCode	VARCHAR2(13)		PRIMARY KEY,
    pName	nVARCHAR2(50)	NOT NULL	,
    pItem	nVARCHAR2(10)	NOT NULL	,
    pIPrice	NUMBER		,
    pOPrice	NUMBER		
 );
 
 -- 거래처정보 테이블 생성
 create table tbl_buyer (
    buId	VARCHAR2(10)		PRIMARY KEY,
    buName	nVARCHAR2(20)	NOT NULL	,
    buTel	VARCHAR2(15)	NOT NULL	,
    buAddr	nVARCHAR2(125)		
 );
 
 /*
 판매내역 Table 에서 사용할 SEQUENCE 객체 생성하기
 일련번호를 자동으로 생성하기 위한 객체
 
 시작 1 부터 1씩 자동으로 증가하는 일련번호를 만든다.
 */
 create sequence seq_iolist
 start with 1 INCREMENT by 1;
 
 -- ioSEQ default 설정하기 위하여 drop 후 create 실행
 DROP table tbl_iolist;
 -- 판매내역 테이블 생성
 /*
 table 생성할 때 ioSEQ 컬럼을 다음과 같이 설정
    ioSEQ	NUMBER		 default seq_iolist.nextval PRIMARY KEY,
    
    tbl_iolist 테이블에 insert 를 실행할 때 마다 자동으로
    seq_iolist.nextval 코드가 실행될 것이다.
 */
 create table tbl_iolist (
    ioSEQ	NUMBER		 default seq_iolist.nextval PRIMARY KEY,
    ioDate	VARCHAR2(10)	NOT NULL,	
    ioTime	VARCHAR2(10)	NOT NULL,	
    ioBuId	VARCHAR2(10)	NOT NULL,	
    ioPCode	VARCHAR2(13)	NOT NULL,	
    ioQuan	NUMBER	NOT NULL	,
    ioPrice	NUMBER	NOT NULL	,
    ioTotal	NUMBER		

 );
 /*
 tbl_iolist 에 데이터를 추가(INSERT)할 때 ioSEQ 칼럼에 자동 증가된 값을
 추가하기 위하여 항상 seq_iolist.NEXTVAL 이라는 코드를 입력해야 한다.
 간혹 실수로 해당 코드를 생략하면 insert 명령에서 오류가 발생한다.
 테이블을 생성할 때 default 옵션을 설정하여 wkehddmfh tlfgodehlehfhr gkduqhwk
 */
 insert into tbl_iolist(ioSEQ) values(seq_iolist.nextval);
 
 insert into tbl_iolist(ioDate, ioTime, iobuid, iopcode, ioquan, ioprice)
 values('2023-06-16', '11:32:00', '0000000001', '0000000000001', 10, 12000);
 select * from tbl_iolist;
 
 commit;