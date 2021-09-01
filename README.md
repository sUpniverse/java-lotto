# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기 TODO
- 쉼표(,) 또는 콜론(:)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환해야 한다.

  - [x] 빈 문자열 혹은 null 값을 입력할 경우 0을 반환해야 한다.
  - [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환해야 한다.
  - [x] 숫자 두 개를 컴마(,)로 구분지어 입력할 경우 두 숫자의 합을 반환해야 한다.
  - [x] 구분자를 컴마(,) 이외에 컬럼(:)을 사용하여 구분지을 수도 있다.

- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

  - [x] 커스텀 구분자 추가

- 문자열 계산기에 숫자 이외의 값 혹은 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

  - [x] 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw한다.
  - [x] 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 로또(자동) TODO
### default
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### todo
- 로또 번호
  - [x] 로또 하나에는 번호가 저장되어야 한다.
  - [x] 로또 번호는 1~45 사이의 숫자여야 한다.
  - [x] 로또 하나에 번호가 6개 저장되지 않으면 RuntimeException 예외를 throw한다.
  - [x] 로또 하나에 동일한 번호가 들어오면 RuntimeException 예외를 throw한다.
  - [x] 로또 번호는 오름차순으로 정렬되어 저장되어있어야 한다.
  - [x] 구입 개수에 따라 로또 번호 모음을 저장할 수 있다.

- 번호 생성
  - [x] 로또 번호를 랜덤하게 생성할 수 있다.
  - [x] 로또 번호를 1~45 사이의 숫자를 생성할 수 있다. 
  - [x] 생성한 로또 번호를 오름차순으로 정렬할 수 있다.

- 당첨 번호
  - [x] 당첨 번호를 입력하고 저장할 수 있다.
  - [x] 당첨 번호와 로또 번호의 일치 갯수를 계산할 수 있다.
  - [x] 현재 사용한 금액과 수익률을 계산할 수 있다.

- 금액
  - [x] 구입금액을 받았을 때 로또 구입 갯수을 반환받을 수 있다.
  - [x] 해당 로또의 등수를 반환받을 수 있다.

- 화면 설계

## 로또(2등) TODO
### default
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### todo

- [x] 당첨 로또에 보너스 번호를 추가할 수 있다.
- [x] 당첨 로또는 로또와 동일한 제약사항을 가진다.

- [x] 당첨 결과에서 5개 일치 + 보너스볼이 일치의 경우 2등으로 간주한다.
- [x] 보너스볼도 나머지 볼과 동일한 제약사항을 가진다.
- [x] 보너스볼은 다른 로또번호와 같아서는 안된다.

- [x] 보너스 볼의 추가로 Rank를 재정의한다.

## 로또(수동) TODO
### default
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### as-is

- 자동 구매에 대한 내용만 담겨 있다.
- 구매 불가에 대한 Exception이 자동로또 구매시에 걸려있다.

### todo

- 입력
  - [x] 수동으로 구매할 로또 수를 입력받을 수 있다.
  - [x] 수동 구매 로또수에 맞게 수동 구매 로또를 입력 받을 수 있다.
- 지갑 저장
  - [x] 수동 구매 로또를 입력받으면 지갑에서 돈을 차감하고 로또를 저장한다.
  - [x] 수동 구매 로또가격보다 보유 금액이 작을 경우 Exception을 throw한다.
  - [x] 수동 구매 후 남은 금액이 있다면 남은 금액으로 자동 구매를 한다.
  - [x] 로또를 구매요청 시 구매가 불가능하면 Exception을 throw한다.
- 결과 반환
  - [ ] 결과 계산받은 지갑에 로또가 없으면 Exception을 throw한다.
- 화면 설계
  - [x] 수동 구매 로또와 자동 로또 구매수를 반환한다.