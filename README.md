# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 문자열 덧셈 계산기
## 기능 목록
- StringAddCalculator
    - 입력 값이 구분자를 통해 정상적으로 들어오면 덧셈해서 리턴한다.
    - 입력 값이 null 이나 비어있는 값이 오면 0를 리턴한다.
- UserInput      
    - 입력 값이 null 이나 비어있는 값이 오면 false를 리턴한다.
- StringSplitter
  - \\ \n 사이에 들어오는 구분자를 Delimiter로 리턴한다.
  - 실제로 add되어야 할 Items 를 반환한다.
- Delimiter  
    - 기본 구분자는 ':' ',' 둘다 지원한다.
    - \\ \n 사이에 들어오는 구분자도 지원한다.
    - Delimiter의 Symbol 값 존재 여부를 검증한다.
- Items
    - sum() 호출시 모든 값을 더해서 반환한다.
- Item
    - 음수 값 / 문자열이 있을 경우 Runtime Exception을 발생시킨다.
    - add() 인자로 들어온 값과 지금의 값을 합쳐서 합계를 반환한다.
