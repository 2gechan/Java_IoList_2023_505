# Java IoList Project
- java, Oracle 을 사용한 Console Project
- eClipse 의 Console 환경에서 java 를 사용한 DBMS 핸들링
- 상품관리, 고객관리, 상품구매(장바구니)를 관리하는 Project

## 필요한 3rd party Library
- ojdbc*.jar, mybatis*.jar

## Maven Project
- java project 로 설정된 기본 형식을 Maven Project 로 변환한다. : 프로젝트에서 우클릭 > configure > convert maven project
- pom.sml 이라는 파일ㅇ ㅣ생성된다.

### pom.xml
- POM : `Project Object Model` 포르젝트에 필요한 3rd JDK를 쉽게 관리하기 위한 도구
- Maven Project 를 컴파일 하고, Build 하는데 필요한 설정 정보를 가지고 있는 문서