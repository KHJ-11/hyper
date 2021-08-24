# Hyperinbox
#### 개발기간 : 2021년 06월 01일 ~ 2021년 07월 30일
---
### [ 개요 ]

**디자인 협업 소프트웨어 하이퍼인박스 모바일버전**

slack, figma, github등의 협업 툴을 한곳에서 사용할 수 있는\
기존의 하이퍼인박스 데스크톱 앱을 모바일버전으로 제작 
* 로그인
* 인박스
* 프로젝트
* 검색
* 마이페이지
---
### [ Preview ]
[파이널 챌린지 Pt_.pdf](https://github.com/KHJ-11/hyper/blob/main/%ED%8C%8C%EC%9D%B4%EB%84%90%20%EC%B1%8C%EB%A6%B0%EC%A7%80%20Pt_.pdf)

![hyper](https://user-images.githubusercontent.com/72050086/130312503-091b4aa1-80f8-4142-8bdd-9bc2a3eca42c.png)
---
### [ 개발환경 ]
* Language : Kotlin, Java
* Front-end : Android studio
* back-end : Spring boot, mySql, Tomcat
* Design : Figma
---
### [ 라이브러리 ]
* OkHttp
* CardView
---
### [ 역할 ]
* Plan
* Design
* Development
---
### [ 구현 ]
* 로그인

  ```
  - 아이디
    - addTextChangedListener로 아이디 미입력, 이메일양식 불일치시 알림 메시지 설정
  - 비밀번호
    - addTextChangedListener로 비밀번호 미입력시 알림 메시지 설정
  - 로그인
    - OkHttp를 이용하여 서버 Api를 불러와 값 불일치시 알림 메시지 설정
    - 값 일치시 로그인 성공
  - 비밀번호 찾기
  ```
  
* 인박스

  ```
  - 아이템
    - RecyclerView를 이용하여 아이템 리스트 나열
    - RecyclerView를 이용하여 아이템 클릭시 세부페이지로 이동
      - RecyclerView를 이용하여 메시지 입력시 Content추가
    - paintFlags를 이용하여 체크박스의 체크상태에 따라 해당 아이템에 취소선 표시 설정
  - New Task
    - RecyclerView를 이용하여 리스트에 아이템 추가
  ```

* 프로젝트

  ```
  - 플로팅 버튼
    - Animation을 이용하여 플로팅 버튼 클릭시 Open, Close
    - 아이템 생성
      - RecyclerView를 이용하여 버튼 클릭시 
    - 아이템 삭제
  - 아이템
    - RecyclerView를 이용하여 Gird형식으로 아이템 추가 
  ```
  
* 검색

  ```
  - 검색
  ```
  
* 마이페이지

  ```
  - 마이페이지
  ```
