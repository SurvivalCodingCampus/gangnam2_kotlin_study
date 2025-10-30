# Kotlin

## 오늘 배운것
git commit convention
- feat: 새로운 기능 추가
- fix: 버그 픽스
- docs: 문서 수정
- style: 포맷, 세미 콜론 수정, Optimize import, Code Clean up 등 코드가 아닌 스타일에 관련된 수정
- refactor: 코드 리팩토링
- test: 테스트 코드 추가
- chore: 빌드 관련 업무 수정(안드로이드일 경우 manifest, build.gradle)
  - ※외국의 대기업은 자유롭게 convention없이 commit하지만 국내대기업은 이상하게 양식에 신경을 쓴다.

개념 
- 생성자: 객체를 만들어주는 메소드

테스트 코드 작성방법
- IntelliJ에서 윈도우즈일 경우 Alt + Enter 누르면 옵션메뉴가 나타나는데 create Test

테스트 코드 작성
- 여러가지 테스트 기법 중 given > when > then 기법을 사용한다.
- assert*함수를 활용한 기법