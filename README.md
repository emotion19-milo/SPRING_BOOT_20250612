## 2주차 수업

-스프링부트의 기초

: 스프링부트에 대한 기초 지식을 알고, 설치 및 간단한 실습을 진행하였다.

[개념]

: 스프링 프레임 워크는 오픈 소스 기반 웹 프레임워크, 스프링 부트의 핵심은 작은 규모 및 단순 서블릿 관리이다.

: 서블릿 내부 동작

ㄴ프론트 컨트롤러 역할(페이지 요청/응답 처리)

-1. /이름 형태로 uri 요청

-2. 컨트롤러 및 모델을 통해 정보 전달

-3. Thymeleaf가 서버 측에서 HTML 렌더링 응답

-Thymeleaf란?

ㄴHTML 기반 템플릿 엔진

-주요 기능: 데이터 바인딩, 연산, 객채 호출 등/ 템플릿 Fragment/전용 제어문(반복/조건 등)


## 3주차 수업

-포트폴리오 홈페이지 제작 및 수정

: 포트폴리오 홈페이지를 생성해 프로필 사진을 변경하거나 아이콘을 바꾸고 웹사이트의 상세 페이지를 생성하였다.

<img width="2844" height="1664" alt="Image" src="https://github.com/user-attachments/assets/8582f1ee-6bfe-41cc-b59e-9f89e58dce51" />

ㄴ홈페이지

<img width="2868" height="1654" alt="Image" src="https://github.com/user-attachments/assets/62d7530c-352d-4087-a95a-aeec98398b56" />

ㄴ상세페이지

[개념]

-웹 호스팅: 서버의 일부(공간)을 임대하여 사용

ㄴ일반 웹: 카페24, 아임웹, 윅스, 가비아 등-저렴

ㄴ맞춤형: VPS 호스팅, 클라우드(확장)-비용 높음


## 4주차 수업

-프로필 수정 및 데이터베이스 연동

: MySQL 설치 및 연동, 확장 프로그램 설치. 확장 프로그램으로 데이터베이스 연동.

[개념]

-데이터베이스 연동

ㄴ데이터 제어와 영속성 제공/영속성: 종료 이후 DB 저장

ㄴ영속 계층에 위치

-Repository 내부의 엔티티 매니저

ㄴ영속성 컨텍스트 자동 관리

ㄴ트랜잭션 처리의 복잡성 감소

-내부 구조 

-> M : model 또는 domain 폴더

ㄴ객체 클래스-엔티티/ DB 테이블 구조 

-> V : view, 기존 templates 폴더

ㄴ화면

-> C : controller 폴더

ㄴ요청/응답 흐름 제어/반환

-> Service : service 폴더

ㄴ중간 로직 처리(데이터 가공)

-> Repository : repository 폴더

ㄴDB 연결/접근(쿼리)


## 5주차 수업

-로그인 및 로그아웃 페이지 생성 및 암호화

: 로그인 및 로그아웃 페이지를 생성하고 회원 정보를 암호화하여 저장할 수 있도록 하였다. 또한 회원가입, 로그인, 로그아웃 절차가 정상적으로 잘 이뤄지는지 확인하고 데이터 저장이 제대로 암호화 상태로 저장되는지 확인하며 오늘의 실습을 마무리하였다.

<img width="2850" height="1648" alt="Image" src="https://github.com/user-attachments/assets/01e43c4d-957b-4ec4-8dad-34a1ddf68530" />

ㄴ로그아웃 후 로그인 페이지

[개념]

-의존성 모듈 추가

ㄴ필터 기반 보안 

: 요청이 컨트롤러에 도착하기 전에 검사

: 여러 보안 필터가 체인처럼 연결

  ㄴ다양한 조건 검사: 로그인 화면 이동(302) 혹은 거부(403)

-로그인 연결

: 로그인 폼 제출(POST/login)

ㄴ스프링 시큐리티 필터가 아이디, 비밀번호 추출

ㄴ loadUserByUsername(아이디) 호출

ㄴPasswordEncoder.matches(입력 비밀번호, DB 해시) 비교
 -> BCrypt는 암호화할 때마다 랜덤 솔트(salt)적용, 직접 비교 구현 X

ㄴ일치하면 로그인 성공, 세션에 인증 정보 저장


## 6주차 수업

-권한 관리 및 관리자 페이지 생성

: admin에 회원 관리 권한을 부여하고 회원 관리 페이지를 생성하였다.

<img width="2842" height="1632" alt="Image" src="https://github.com/user-attachments/assets/32d6eab2-b6b5-4381-a7f3-1a44a263eb45" />

ㄴ회원 삭제 후 페이지

<img width="2844" height="1642" alt="Image" src="https://github.com/user-attachments/assets/bf4e702d-012d-4f78-8528-84dacd54c101" />

ㄴ일반 회원을 관리자로 변경(실제 적용은 되지 않음)

<img width="2842" height="1626" alt="Image" src="https://github.com/user-attachments/assets/88f4bb2c-1f7f-43b8-a063-580c3a0fdd76" />

ㄴ매니저로 권한 변경(되지 않음)

<img width="2842" height="1630" alt="Image" src="https://github.com/user-attachments/assets/cf49341b-ba0c-486f-8dbc-3e7cb1d6e1ca" />

ㄴ일반 회원으로 로그인하고 관리자 페이지 접근 시 페이지


## 7주차 수업

-API를 생성하고 Postman을 통해 생성된 API 확인 및 테스트를 하였다.

: JSON 데이터가 제대로 응답하는지 확인했다.

: Postman에서 POST 회원 등록을 해보았다.

: 회원관리 페이지에서 API 버전으로 볼 수 있는 페이지를 생성하였다.

<img width="616" height="434" alt="Image" src="https://github.com/user-attachments/assets/d78962d5-c377-4924-969c-7ac0d6e6e9dd" />

ㄴapi 페이지

<img width="1820" height="1420" alt="Image" src="https://github.com/user-attachments/assets/6491af8d-0be6-4e72-a246-0336006eb83d" />

ㄴPostman 페이지

<img width="2858" height="1632" alt="Image" src="https://github.com/user-attachments/assets/03455219-a282-4e9d-8067-45b30c6f86ba" />

ㄴAPI 버전으로 회원관리 페이지 보기

[개념]

-상태 코드

ㄴ응답: 상태 코드 + 헤더 + 본문

-200 OK: 성공: 조회, 수정 성공

-201 Created: 새로 만들었음: 등록 성공

-204 No Content: 성공, 돌려줄 내용 없음: 삭제 성공

-400 Bad Request: 요청 내용이 잘못 됨: 빈 값, 중복아이디, 허용 안되는 권한

-401 Unauthorized: 누구인지 모름: 로그인 정보 없음

-403 Forbidden: 권한 없음: USER가 관리자 API 호출

-404 Not Found: 대상이 없음: 없는 회원번호 조회