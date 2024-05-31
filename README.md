# 5-Jun2-Java-Casino

```text

 _    _        _                                 _              ___                _____   _____              _                _ 
| |  | |      | |                               | |            |_  |              / __  \ /  __ \            (_)              | |
| |  | |  ___ | |  ___   ___   _ __ ___    ___  | |_   ___       | | _   _  _ __  `' / /' | /  \/  __ _  ___  _  _ __    ___  | |
| |/\| | / _ \| | / __| / _ \ | '_ ` _ \  / _ \ | __| / _ \      | || | | || '_ \   / /   | |     / _` |/ __|| || '_ \  / _ \ | |
\  /\  /|  __/| || (__ | (_) || | | | | ||  __/ | |_ | (_) | /\__/ /| |_| || | | |./ /___ | \__/\| (_| |\__ \| || | | || (_) ||_|
 \/  \/  \___||_| \___| \___/ |_| |_| |_| \___|  \__| \___/  \____/  \__,_||_| |_|\_____/  \____/ \__,_||___/|_||_| |_| \___/ (_)
                                                                                                                                 
                                                                                                                                 
```
[노션 정리 링크](https://www.notion.so/goorm/6-2-ca4fec41f09a4869a9ae65c9a737a273?pvs=4)

---
# 🚀 주요 기능 목록

## 🧍‍플레이어 기능
### 초기 설정 기능
- 플레이어 정보 설정 기능
- 플레이어 초기 자금 설정 기능 (최소 금액 1,000원 ~ 최대 금액 1,000,000원)
- 플레이어 정보 저장 및 조회 기능

## 🏦 환전소 기능 
### 1) 보유 자금 조회 기능
- 현금, 칩 개수 모두 조회 가능

### 2) 칩 환전 기능
- 현금 → 칩 환전 기능
- 칩 → 현금 환전 기능

## 🏨 카지노 기능
### 1) 슬롯 머신 기능
- 현금 결제 방식 (1회 비용 : 5,000원)
### 2) 룰렛 게임 기능
- 칩 베팅 방식
### 3) 블랙잭 게임 기능
- 칩 베팅 방식

---
# 🔎 게임 정보

## 💵 머니 칩 설명
- 풀 세트가 아닌 `기존 세트` 를 적용
1. **하얀색** : 1,000 원 (1$)
2. **분홍색** : 2,500 원 (2.5$)
3. **빨간색** : 5,000 원 (5$)
4. **파란색** : 10,000 원 (10$)
5. **초록색** : 25,000 원 (25$)
6. **검은색** : 100,000 원 (100$)
---

## 🎴 카지노 설명

### 🎰 슬롯 머신 (Slot Machine)
#### 설명
- 단순히 무늬를 맞추는 방식으로 100% 운에 의존하는 게임
- 칩을 넣으면 무늬가 나오는데, 크레딧의 라인과 당첨 조합이 일치하면 칩을 얻고, 그렇지 않으면 잃는다.
- 당첨 조건
    - JACK POT 777 : 모든 숫자가 7인 경우 - 당첨금 10,000,000 원 지급
    - JACK POT : 모든 숫자가 같은 경우 - 당첨금 1,000,000 원 지급
    - STRAIGHT UP : 오름차순으로 연속된 숫자인 경우 - 당첨금 500,000 원 지급
    - STRAIGHT DOWN : 내림차순으로 연속된 숫자인 경우 - 당첨금 100,000 원 지급
      <br><br>

### 🎯 룰렛 (Roulette)
#### 설명
![image](https://github.com/junseoparkk/5-jun2-java-casino/assets/98972385/9323df0b-f6f5-45ca-b9ba-f487a6f067a2)
- 유럽식 룰렛을 따름 -> 00 (더블 제로) 미포함
- 0 ~ 36 까지 37개의 숫자가 존재, 어느 숫자에 볼이 떨어지는지 맞히는 게임

#### 배당금 지급 조건
- A. `Straight Bet`  : 한 개 숫자에 베팅, 배당금 : 35배
- B. `Split Bet`  : 두 개 숫자 동시에 베팅, 배당금 : 17배
- C. `Street Bet`  : 일렬로 놓여진 세 개 숫자 동시에 베팅, 배당금 : 11배
- D. `Square Bet`  : 네 개의 숫자 동시에 베팅, 배당금 : 8배
- E. `Five Number Bet`  : 1, 2, 3, 0 동시에 베팅, 배당금 : 6배
- F. `Six Number Bet`  : 이어지는 여섯 숫자에 동시 베팅, 배당금 : 5배
- G. `Column Bet`  : 세로로 일렬하는 12개 숫자에 동시 베팅, 배당금 : 2배
- H. `Dozen Bet`  : 레이아웃의 “1st 12”, “2nd 12”, “3rd 12”에 베팅, 배당금 2배
    - 각각 1 ~ 12, 13 ~ 24, 25 ~ 36 을 가리킴
- I. `High / Low Number Bet`
    - Low Number Bet : 1 ~ 18 까지의 숫자에 베팅, 배당금 1배
    - High Number Bet : 19 ~ 36 까지의 숫자에 베팅, 배당금 1배
- J. `Even / Odd Number Bet`  : 0을 제외한 모든 번호를 짝수와 홀수로 구분하여 베팅, 배당금 1배
- K. `Color Bet`  : 0을 제외한 모든 번호를 적색과 흑색으로 구분하여 베팅, 배당금 1배
---

### 🃏 블랙잭 (Blackjack)
#### 설명
1. 딜러는 플레이어에게 두 장의 카드를 지급
2. 딜러는 숫자가 보이는 카드 1장, 뒷면의 카드 1장을 갖고 게임 시작
3. 플레이어는 자신의 패를 확인하고 플레이 방법을 결정
4. 카드 합이 21에 가까운 쪽이 이기는 게임
    - ACE 카드는 1이나 11로 취급
    - 10, J, Q, K는 모두 10으로 취급

### 플레이어 규칙
1. **블랙잭 (Black Jack)**
    - 처음 2장의 카드를 받았을 때 ACE 1장 + 10의 가치를 가진 카드 1장 → 총 21의 카드를 받았다면 블랙잭
    - 만약 딜러 또한 블랙잭이 아니라면 플레이어의 승리로, 게임을 진행하지 않고 베팅 금액의 1.5배를 지급
    - 만약 딜러 또한 블랙잭이라면 그대로 게임 종료
2. **히트 (Hit)**
    - 자신이 보유한 패의 총계를 올리기 위해 카드를 추가로 지급 받는다.
    - 플레이어의 카드 합이 21을 넘어가면 `버스트(Burst)`  → 게임 종료
3. **서렌더 (Surrender)**
    - 처음 받은 패가 마음에 들지 않는다면, 최초 베팅 금액의 절반을 돌려받는 대신 게임을 포기

#### 딜러 규칙
1. 플레이어의 패(핸드)가 버스트 되거나 서렌더를 선언하지 않았다면 딜러의 차례
2. 뒷면이었던 홀 카드(Hole Card)를 뒤집어 카드의 가치 합을 확인
    1. 딜러 핸드의 합이 17 이상이면 자동으로 스탠드(Stand)
    2. 딜러 핸드의 합이 16 이하라면 추가로 히트(Hit) 카드를 받음
    3. 더블다운, 스플릿, 서랜더 선택 불가능
    4. 선택의 여지 없이 핸드의 합계에 따라 플레이가 정해짐
       <br><br>

#### 카드 가치
![image](https://github.com/junseoparkk/5-jun2-java-casino/assets/98972385/75b78bc3-aa5a-412e-aa13-edda68ec1c2a)
- Ace = 1
- King, Queen, Jack, 10 = 0
- 2 ~ 9까지 = 표시된 숫자
- 합이 10 이상인 경우 일의 자리만 계산

#### 게임 규칙
1. 이긴 측에 베팅한 경우
    - 베팅액의 1배를 지급 받음
2. `Tie Bet` 이 당첨된 경우
    - Tie : 플레이어와 뱅커 양쪽 카드의 합이 같은 값인 경우
    - 베팅액의 8배를 지급 받음
3. `Pair Bet` 이 당첨된 경우
    - Pair : 최초 두 장의 카드가 같은 숫자가 나오는 것
    - 베팅액의 11배를 지급 받음
4. `Player's Rule` , `Banker's Rule`
    - ![image](https://github.com/junseoparkk/5-jun2-java-casino/assets/98972385/4dcb5a23-9eba-4888-9c5c-311796968fc2)
5. `Fortune 6` 이 당첨된 경우
    - Fortune 8 : 뱅커의 카드 합이 6으로 이긴 경우
    - 카드가 2장일 경우 베팅액의 12배, 3장일 경우 20배 지급
---

# 💡고민한 점

## 1️⃣ 게임 도메인의 책임과 분리

### 배경

- 게임 기능을 개발하면서 아래와 같은 단계를 거쳐 객체와 각 레이어의 역할을 정립하고 리팩토링 진행

### 1) Controller 리팩토링

### ❌ 리팩토링 전

- 초기에 3개의 컨트롤러 설계 → `CasinoController` , `ExchangeController` , `CasinoGameController`
- 게임 실행 흐름을 제어하는 `CasinoGameController` 구현 중 → 게임 옵션을 입력 받아 해당 게임을 실행하는 역할 뿐만 아니라, 각 게임의 플레이 흐름과 입출력을 제어하는 메서드도 존재했음
- 결국 각 게임의 플레이 흐름과 입출력을 제어하는 **게임별 컨트롤러의 필요성**에 대해 고민

<details>
<summary>리팩토링 전 CasinoGameController 코드</summary>
1. process() : 게임 옵션에 따른 실행 흐름을 관리하는 메서드

```java
public class CasinoGameController implements Controller {
		...
		
    @Override
    public void process() {
        GameOption gameOption;

        do {
            gameOutputView.printBlankLine();
            gameOutputView.printGameOption();
            gameOption = gameInputView.readGameOption();
            playGame(gameOption);
        } while (gameOption.isContinue());
    }

    private void playGame(GameOption gameOption) {
        Player player = (Player) casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
        Game game = gameService.generateGame(gameOption.getType(), player);
        gameOutputView.printGameGreet(gameOption.getType());

        try {
            if (gameOption == GameOption.SLOT_MACHINE) {
                playSlotMachine(game, player);
            } else if (gameOption == GameOption.ROULETTE) {
                playRoulette(game, player);
            } else if (gameOption == GameOption.BLACKJACK) {
                playBlackjack(game, player);
            } else if (gameOption == GameOption.BACCARAT) {
                playBaccarat(game, player);
            }
        } catch (Exception e) {
            gameOutputView.printException(e.getMessage());
        }
    }
    
    ... // 게임 플레이 흐름을 관리하는 로직
}
```
<br>
2. playXXX() : XXX 게임 플레이 흐름을 관리하는 메서드 (위 코드 밑에 존재)

```java
public class CasinoGameController implements Controller {
		... // 게임 옵션에 따른 실행 흐름을 관리하는 로직 
		
		private void playSlotMachine(Game game, Player player) {
        boolean playGame = gameInputView.readSlotMachinePayment();

        if (playGame && !game.isPlay()) {
            game.changeStatus();
        }
        if (!playGame) {
            return;
        }
        while (game.isPlay()) {
            SlotMachineGameResultDto result = gameService.playSlotMachine(game, player);
            gameOutputView.printSlotMachineResult(result);

            boolean retry = gameInputView.readRetryGame();
            if (retry) {
                playSlotMachine(game, player);
            } else {
                game.changeStatus();
                return;
            }
        }
    }

    private void playRoulette(Game game, Player player) {
        gameOutputView.printPlayerChips(player.getChipsBalance());
        Map<ChipType, Integer> betChips = gameInputView.readBetChips(GameType.ROULETTE);
        if (!game.isPlay()) {
            game.changeStatus();
        }

        while (game.isPlay()) {
            player.validateChipsToPlay(betChips);
            gameOutputView.printRouletteBetType();
            RouletteBetType betType = gameInputView.readRouletteBetType();
            playRouletteByBetType(betType, game, player, betChips);
            game.changeStatus();
        }
    }
    ...		
}
```
</details>

1. `CasinoGameController` ****에서 각 게임의 플레이 흐름까지 제어하면 확장이나 유지보수가 매우 어려울 것이라고 생각함. 따라서 다음과 같은 고민을 하게 됨
    1. 게임의 흐름을 관리하는 로직은 Service 레이어에 포함되어야 하나?
    2. 게임의 흐름을 관리하는 로직은 비즈니스 로직이므로 각 게임 클래스에 구현해야 하나?
2. 각 레이어 별로 어떤 역할을 가져야 할지 고민 후 다음과 역할을 정립
    1. `Controller` : Service 레이어와 통신하여 전반적인 코드의 흐름을 관리하는 역할
    2. `Service` : 비즈니스 로직을 가지거나 상위 ↔ 하위 레이어 통신 역할
    3. `Domain` : 핵심 비즈니스 로직을 가지며, 단순히 getter, setter 메서드만 존재하면 안됨

### 리팩토링 후

- 기존 3개의 컨트롤러에 더해 각 게임별 컨트롤러를 추가함 → `SlotMachineController` , `RouletteController` , `BlackjackController`
- 게임별 컨트롤러를 분리함으로써 위 컨트롤러들은 각 게임의 플레이 흐름을 제어하는 역할만을 가짐
- 결국 `CasinoGameController` 는 옵션에 따라 게임별 컨트롤러를 실행하는 역할만 가질 뿐, 게임에 대한 정보를 몰라도 되기 때문에 결합도가 낮아지며 의존성 또한 제거됨
- 컨트롤러는 인터페이스에 의존하기 때문에 `DIP` 만족, 확장에 용이하게 됨

<details>
<summary>리팩토링 후 CasinoGameController 코드</summary>

```java
public class CasinoGameController implements Controller {
		...

    @Override
    public void process() {
        GameOption gameOption;

        do {
            gameResponse.printBlankLine();
            gameResponse.printGameOption();
            gameOption = request.getGameOption();
            processController(gameOption);
        } while (gameOption.isContinue());
    }

		// 게임 컨트롤러 세팅
    private void initializeControllers(CasinoConfig casinoConfig) {
        controllers.put(SLOT_MACHINE, new SlotMachineController(casinoConfig));
        controllers.put(ROULETTE, new RouletteController(casinoConfig));
        controllers.put(BLACKJACK, new BlackjackController(casinoConfig));
    }

		// 옵션에 따른 컨트롤러 실행
    private void processController(GameOption gameOption) {
        if (gameOption == GameOption.QUIT) {
            return;
        }

        GameController controller = controllers.get(gameOption.getType());

        try {
            Player player = (Player) casinoMainService.findParticipantByRoleType(RoleType.PLAYER);
            Game game = GameGenerator.generateGame(gameOption.getType(), player);
            gameResponse.printGameGreet(gameOption.getType());
            controller.process(game, player);
        } catch (Exception e) {
            gameResponse.printException(e.getMessage());
        }
    }
}
```
</details>
<br>

---
### 2) Service, Domain 리팩토링

### ❌ 리팩토링 전

- 컨트롤러를 분리하는 단계에서 Service 레이어의 역할에 대해서도 고민하게 됨
- 기존 `GameService` 에서는 각 게임별 비즈니스 로직을 실행하는 역할을 가졌음
    - 게임을 생성하는 로직이 존재
    - ex) 슬롯 머신의 경우 이용료를 지불하는 로직, 당첨금 계산 로직, 당첨금 지급 로직 등이 함께 존재
    - ex) 룰렛의 경우 이용료를 지불하는 로직, 베팅 로직, 베팅 옵션별 당첨금 계산 로직 등이 함께 존재

  → `GameServiceImpl` 의 코드는 200줄이 넘어갔고, 역시 확장과 유지보수에 매우 안좋다고 생각함

<details>
<summary>GameService 코드 (interface)</summary>

```java
public interface GameService {
    public Game generateGame(GameType type, Player player);
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player);
    public RouletteGameResultDto playRoulette(RouletteBetInfoDto info, Game game, Player player);
		public void playBlackjack(Game game,Player player);
}

```
</details>

<details>
<summary>리팩토링 전 GameServiceImpl 코드 (implements)</summary>

```java
public class GameServiceImpl implements GameService {
    private static final int SLOT_MACHINE_PRICE = 5000;

    // 게임 종류에 따라 게임을 생성하는 로직
    @Override
    public Game generateGame(GameType type, Player player) {
        if (type == SLOT_MACHINE) {
            return new SlotMachineGame(type, player, STOP);
        } else if (type == ROULETTE) {
            return new RouletteGame(type, player, STOP);
        } else if (type == BLACKJACK) {
            return new BlackjackGame(type, player, STOP);
        } else {
            return new BaccaratGame(type, player, STOP);
        }
    }

    @Override
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player) {
        if (player.getCashBalance() < SLOT_MACHINE_PRICE) {
            throw new IllegalStateException("[ERROR] 현금이 부족합니다. (슬롯 머신 이용료 : 5,000원)");
        }

        // 슬롯 머신 이용료 지불
        player.updateCash(false, SLOT_MACHINE_PRICE);

        SlotMachineGame slotMachineGame = (SlotMachineGame) game;
        int[] numbersResult = slotMachineGame.generateRandomNumbers();
        SlotMachineResult result = slotMachineGame.calculateWinningResult(numbersResult);

        // 당첨되었다면 당첨금 지급
        if (result != SlotMachineResult.NONE) {
            player.updateCash(true, result.getWinningAmount());
        }
        return new SlotMachineGameResultDto(result, numbersResult);
    }

    @Override
    public RouletteGameResultDto playRoulette(RouletteBetInfoDto info, Game game, Player player) {
        RouletteBetType betType = info.betType();
        Map<ChipType, Integer> betChips = info.betChips();
        RouletteGame rouletteGame = (RouletteGame) game;
        int betNumber = info.betNumber();
        int winningNumber = rouletteGame.generateRouletteNumber();

        // 룰렛 이용료 지불
        payPlayerChips(player, betChips);

        // 사실 서비스 로직이 아니라 RouletteGame 에 도메인 로직으로 넣는게 맞지 않을까?
        if (betType == STRAIGHT_BET) {
            if (winningNumber == betNumber) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
            }
        } else if (betType == SPLIT_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
            }
        } else if (betType == STREET_BET) {
            if (betNumber <= winningNumber && winningNumber <= betNumber + 2) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
            }
        } else if (betType == SQUARE_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1
                    || winningNumber == betNumber + 3 || winningNumber == betNumber + 4) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
            }
        } else if (betType == FIVE_NUMBER_BET) {
            if (winningNumber == 1 || winningNumber == 2 || winningNumber == 3 || winningNumber == 0) {
                giveWinningAmount(player, betChips, betType);
                long totalWinningAmount = calculateWinningAmount(betChips, betType);
                return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
            }
        }
        return playRouletteWithOption(betType, winningNumber, info, player);
    }

    private void payPlayerChips(Player player, Map<ChipType, Integer> betChips) {
        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue();
            player.updateChipCount(false, type, chipCount);
        }
    }

    private void giveWinningAmount(Player player, Map<ChipType, Integer> betChips, RouletteBetType betType) {
        int dividendMultipleNumber = betType.getDividendMultiple();
        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue() * dividendMultipleNumber;
            player.updateChipCount(true, type, chipCount);
        }
    }

    private long calculateWinningAmount(Map<ChipType, Integer> betChips, RouletteBetType betType) {
        int dividendMultipleNumber = betType.getDividendMultiple();
        long totalWinningAmount = 0;

        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue() * dividendMultipleNumber;
            totalWinningAmount += (long) type.getKrw() * chipCount;
        }
        return totalWinningAmount;
    }

    // 리팩토링시 하드코딩 값 수정해야 함 ex) RouletteGameConstants
    private RouletteGameResultDto playRouletteWithOption(
            RouletteBetType betType,
            int winningNumber,
            RouletteBetInfoDto info,
            Player player)
    {
        Map<ChipType, Integer> betChips = info.betChips();
        int optionNumber = info.optionNumber();
        boolean isWin = false;

        if (betType == COLUMN_BET) {
            for (int number = optionNumber; number <= 36; number += 3) {
                if (winningNumber == number) {
                    giveWinningAmount(player, betChips, betType);
                    long totalWinningAmount = calculateWinningAmount(betChips, betType);
                    return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
                }
            }
        } else if (betType == DOZEN_BET) {
            if (optionNumber == 1) {
                if (1 <= winningNumber && winningNumber <= 12) {
                    isWin = true;
                }
            } else if (optionNumber == 2) {
                if (13 <= winningNumber && winningNumber <= 25) {
                    isWin = true;
                }
            } else if (optionNumber == 3) {
                if (25 <= winningNumber && winningNumber <= 36) {
                    isWin = true;
                }
            }
        } else if (betType == HIGH_LOW_NUMBER_BET) {
            if (optionNumber == 1) {
                if (1 <= winningNumber && winningNumber <= 18) {
                    isWin = true;
                }
            } else {
                if (19 <= winningNumber && winningNumber <= 36) {
                    isWin = true;
                }
            }
        } else if (betType == EVEN_ODD_NUMBER_BET) {
            if (optionNumber == 1) {
                if (winningNumber % 2 == 0) {
                    isWin = true;
                }
            } else {
                if (winningNumber % 2 != 0) {
                    isWin = true;
                }
            }
        } else if (betType == COLOR_BET) {
            RouletteColorType colorType = findColorByNumber(winningNumber);
            if (optionNumber == 1 && colorType == BLACK) {
                isWin = true;
            } else if (optionNumber == 2 && colorType == RED){
                isWin = true;
            }
        }
        if (isWin) {
            giveWinningAmount(player, betChips, betType);
            long totalWinningAmount = calculateWinningAmount(betChips, betType);
            return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
        }
        return new RouletteGameResultDto(winningNumber, 0, betType);
    }
}

```
</details>
<br>

### ⭕️ 리팩토링 후

- 기존 Service 레이어에서 게임을 생성하고, 게임 실행을 제어했기때문에 너무 많은 책임이 존재한다고 생각했음. 또한 게임은 비즈니스 로직으로, 각 게임 클래스에서 제어하는 것이 맞다고 판단함
- 결국 `GameServiceImpl` 의 역할은 단순히 게임을 받아와 게임을 실행하는 것으로 정립
- 게임을 생성하는 기능은 `GameGenerator` 에게 위임
- 게임의 흐름을 제어하는 비즈니스 로직은 `각 게임 클래스`에게 위임

<details>
<summary>리팩토링 후 GameServiceImpl 코드</summary>

```java
public class GameServiceImpl implements GameService {
    @Override
    public SlotMachineGameResultDto playSlotMachine(Game game, Player player) {
        SlotMachineGame slotMachineGame = (SlotMachineGame) game;
        return slotMachineGame.play(player);
    }

    @Override
    public RouletteGameResultDto playRoulette(RouletteBetInfoDto info, Game game, Player player) {
        RouletteGame rouletteGame = (RouletteGame) game;
        return rouletteGame.play(info, player);
    }

    @Override
    public void playBlackjack(Game game, Player player) {
				...
    }
}
```
</details>

<details>
<summary>리팩토링 후 게임 클래스 코드 (Domain Layer)</summary>
1. SlotMachineGame

```java
public class SlotMachineGame extends Game {
    private static final int NUMBERS_SIZE = 3;
    private static final int SLOT_MACHINE_PRICE = 5000;

    public SlotMachineGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }

		// 랜덤 숫자 생성
    public int[] generateRandomNumbers() {
        Random random = new Random();
        int[] randomNumbers = new int[NUMBERS_SIZE];
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            randomNumbers[i] = random.nextInt(10);
        }
        return randomNumbers;
    }

    public SlotMachineResult calculateWinningResult(int[] resultNumbers) {
        return SlotMachineResult.calculateWinningResult(resultNumbers);
    }

		// 게임 플레이 메서드
		@Override
    public SlotMachineGameResultDto play(Player player) {
        if (player.getCashBalance() < SLOT_MACHINE_PRICE) {
            throw new IllegalStateException("[ERROR] 현금이 부족합니다. (슬롯 머신 이용료 : 5,000원)");
        }

        // 슬롯 머신 이용료 지불
        player.updateCash(false, SLOT_MACHINE_PRICE);

        int[] numbersResult = generateRandomNumbers();
        SlotMachineResult result = calculateWinningResult(numbersResult);

        // 당첨되었다면 당첨금 지급
        if (result != SlotMachineResult.NONE) {
            player.updateCash(true, result.getWinningAmount());
        }
        return new SlotMachineGameResultDto(result, numbersResult);
    }
}
```
<br>

2. RouletteGame

```java
public class RouletteGame extends Game {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 36;

    public RouletteGame(GameType gameType, Player player, GameStatus status) {
        super(gameType, player, status);
    }

		// 당첨 숫자 생성 메서드
    public int generateRouletteNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER;
    }

		// 게임 플레이 메서드
		@Override
    public RouletteGameResultDto play(RouletteBetInfoDto info, Player player) {
        RouletteBetType betType = info.betType();
        Map<ChipType, Integer> betChips = info.betChips();
        int betNumber = info.betNumber();
        int winningNumber = generateRouletteNumber();

        // 룰렛 이용료 지불
        payPlayerChips(player, betChips);

        boolean isWin = checkIsWinGame(betType, winningNumber, betNumber);
        if (isWin) {
            giveWinningAmount(player, betChips, betType);
            long totalWinningAmount = calculateWinningAmount(betChips, betType);
            return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
        }
        return playRouletteWithOption(betType, winningNumber, info, player);
    }

		// 각 베팅 옵션별 당첨 여부 확인 메서드
    private static boolean checkIsWinGame(RouletteBetType betType, int winningNumber, int betNumber) {
        boolean isWin = false;

        if (betType == STRAIGHT_BET) {
            if (winningNumber == betNumber) {
                isWin = true;
            }
        } else if (betType == SPLIT_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1) {
                isWin = true;
            }
        } else if (betType == STREET_BET) {
            if (betNumber <= winningNumber && winningNumber <= betNumber + 2) {
                isWin = true;
            }
        } else if (betType == SQUARE_BET) {
            if (winningNumber == betNumber || winningNumber == betNumber + 1
                    || winningNumber == betNumber + 3 || winningNumber == betNumber + 4) {
                isWin = true;
            }
        } else if (betType == FIVE_NUMBER_BET) {
            if (0 <= winningNumber && winningNumber <= 3) {
                isWin = true;
            }
        }
        return isWin;
    }

		// 게임 이용료 지불 메서드
    private void payPlayerChips(Player player, Map<ChipType, Integer> betChips) {
        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue();
            player.updateChipCount(false, type, chipCount);
        }
    }
		
		// 당첨금 지급 메서드
    private void giveWinningAmount(Player player, Map<ChipType, Integer> betChips, RouletteBetType betType) {
        int dividendMultipleNumber = betType.getDividendMultiple();
        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue() * dividendMultipleNumber;
            player.updateChipCount(true, type, chipCount);
        }
    }

		// 당첨금 계산 메서드
    private long calculateWinningAmount(Map<ChipType, Integer> betChips, RouletteBetType betType) {
        int dividendMultipleNumber = betType.getDividendMultiple();
        long totalWinningAmount = 0;

        for (Map.Entry<ChipType, Integer> entry : betChips.entrySet()) {
            ChipType type = entry.getKey();
            int chipCount = entry.getValue() * dividendMultipleNumber;
            totalWinningAmount += (long) type.getKrw() * chipCount;
        }
        return totalWinningAmount;
    }

		// 베팅 옵션별 룰렛 게임 결과 정보 반환 메서드 -> 하드 코딩된 값 상수화하면 좋겠지만 패스
    private RouletteGameResultDto playRouletteWithOption(
            RouletteBetType betType,
            int winningNumber,
            RouletteBetInfoDto info,
            Player player) {
        Map<ChipType, Integer> betChips = info.betChips();
        int optionNumber = info.optionNumber();
        boolean isWin = false;

        switch (betType) {
            case COLUMN_BET:
                for (int number = optionNumber; number <= MAX_NUMBER; number += 3) {
                    if (winningNumber == number) {
                        isWin = true;
                        break;
                    }
                }
                break;
            case DOZEN_BET:
                isWin = (optionNumber == 1 && (1 <= winningNumber && winningNumber <= 12))
                        || (optionNumber == 2 && (13 <= winningNumber && winningNumber <= 24))
                        || (optionNumber == 3 && (25 <= winningNumber && winningNumber <= 36));
                break;
            case HIGH_LOW_NUMBER_BET:
                isWin = (optionNumber == 1 && (1 <= winningNumber && winningNumber <= 18))
                        || (optionNumber == 2 && (19 <= winningNumber && winningNumber <= 36));
                break;
            case EVEN_ODD_NUMBER_BET:
                isWin = (optionNumber == 1 && winningNumber % 2 == 0)
                        || (optionNumber == 2 && winningNumber % 2 != 0);
                break;
            case COLOR_BET:
                RouletteColorType colorType = findColorByNumber(winningNumber);
                isWin = (optionNumber == 1 && colorType == BLACK)
                        || (optionNumber == 2 && colorType == RED);
                break;
        }

        if (isWin) {
            giveWinningAmount(player, betChips, betType);
        }

        long totalWinningAmount = isWin ? calculateWinningAmount(betChips, betType) : 0;
        return new RouletteGameResultDto(winningNumber, totalWinningAmount, betType);
    }
}
```
</details>

<details>
<summary>게임 생성기 코드 (Domain Layer)</summary>

```java
public class GameGenerator {
    private static final String NOT_EXIST_GAME = "[ERROR] 존재하지 않는 게임 종류입니다.\n";

    public static Game generateGame(GameType type, Player player) throws IllegalArgumentException {
        if (type == SLOT_MACHINE) {
            return new SlotMachineGame(type, player, STOP);
        } else if (type == ROULETTE) {
            return new RouletteGame(type, player, STOP);
        } else if (type == BLACKJACK) {
            return new BlackjackGame(type, player, STOP);
        }
        // 존재하지 않는 게임인 경우 예외 발생
        throw new IllegalArgumentException(NOT_EXIST_GAME);
    }
}
```
</details>
---

## 2️⃣ Request / Response Layer

### 배경

- 이전에 컨트롤러 분리에 대한 고민 도중 제프에게 아래처럼 질문한 적이 있었음

  [컨트롤러의 책임과 역할 분리](https://www.notion.so/abf2144d99044bb09e63ddcb3b750c02?pvs=21)

- Controller 에서 View 에 대한 의존성을 제거하기 위해 고민함 → 콘솔이 아닌 다른 I/O 방식을 택한다면 해당 프로그램은 비즈니스 로직만 가질 뿐, 사용자와 상호작용할 수 없음
- 제프의 답변중 하나로 ‘`Request` 레이어 추가’ 가 있었고, MVC 패턴을 약간 변형하여 컨트롤러에서 View에 대한 의존성을 없애고 레이어를 추가하기로 결정

### ❌ 리팩토링 전

- 기존 컨트롤러는 `InputView` , `OutputView` 에 의존하고 있었음. → I/O 방법이 바뀐다면 무용지물
- View ↔ Controller 레이어 사이에 새로운 레이어를 추가하여 의존성을 없애는 방법
    - 해당 프로그램은 컨트롤러에서 모든 실행 흐름을 제어하기 때문에 의존성을 아예 없앨 수는 없었음. 또한 제프 역시 Controller가 View를 호출하는 것이 아닌, 외부에서 컨트롤러를 호출하는 방법을 제안
    - 아무리 고민해도 프로그램이 어느정도 구현되어있어 완벽하게 분리할 수는 없었고, `Request` 인터페이스를 통해 확장에 용이하도록 설게 변경


### ⭕️ 리팩토링 후

- `Request` 인터페이스는 사용자와 상호작용하는 메서드를 정의함.
- `ConsoleRequest` 는 Request의 구현체로, 콘솔을 통해 사용자와 상호작용하는 메서드를 제공함
    - 기존 `InputView` , `OutputView` 를 호출하여 기존 코드를 그대로 재사용할 수 있었음
    - getXXX 메서드를 통해 원하는 값을 가져올 수 있음. 말 그대로 컨트롤러 입장에선 요청이 됨
- Controller 에서는 Request 인터페이스에만 의존해 I/O 방법에 상관 없이 사용자와 통신할 수 있게 됨
- 기존 `OutputView` 는 모두 `Resonse` 로 이름을 변경함
---

# 🔥 잘했다고 생각한 점

## 1️⃣ 클린코드

### 1) 변수, 메서드, 클래스 네이밍

- 특히나 네이밍에 많은 시간을 할애
- 일관된 네이밍을 하려고 노력했고, 주석 없이 이름만으로 어떤 역할을 갖는 코드인지 나타내도록 고민함
    - ex) 무언가 가져오는 메서드는 `getXXX` , 찾는 메서드는 `findXXX` , 계산 메서드는 `calculateXXX`  등을 사용
- 코드 자체를 깔끔하고 보기 좋게 하려는 목적도 있지만, 실제로 개발을 할 때 이름을 찾는데 오랜 시간이 걸린다거나, 잘못된 이름으로 오류가 발생하는 것을 방지할 수 있었음

### 2) 코드 컨벤션

- 일관된 코드 컨벤션을 적용해 깔끔한 코드를 작성하도록 고민함
- 띄어쓰기, 인덴트, 연산자 위치 등 컨벤션을 모두 통일

## 2️⃣ DI 적용

- 스프링 컨테이너처럼 DI를 적용하고 싶었고, 순수 자바로 구현하기 위해 `CasinoConfig` 객체를 생각함. 현재 프로젝트는 소규모이고, 사용하는 클래스가 비교적 적기 때문에 하나의 클래스에 모두 구현
- 프로그램 시작점인 `CasinoApplication` 에서 해당 객체를 생성, 주입
- I/O View, Reuqest, Services, Repositories 등의 객체는 해당 클래스에서 생성, 외부에선 메서드를 통해 필요한 클래스를 가져다 쓸 수 있음
- 확장에 유연하게 대응하기 위해서 인터페이스에 의존하는 방법도 있지만, DI를 통해 프로젝트 내 클래스간 의존성을 쉽게 관리
- 입력 방법 또한 해당 클래스에서 정의. 처음 `BufferedReader` 와 `Scanner`  중 고민했지만, 보다 간편하게 사용할 수 있는 Scanner 선택 (BufferedReader은 IOException 처리해야 함 + 버퍼 입력을 사용할 만큼 입력이 많지 않다고 판단함)

## 3️⃣ 유효성 검사 (예외 처리)

- 모든 사용자 입력, 비즈니스 로직 등 프로그램에서 특히나 예외 처리를 꼼꼼하게 구현
- 프로그램 실행 도중 예기치 않은 오류로 프로그램이 종료되는 것을 방지
- 사용자 입력의 경우 잘못된 값 입력시 재귀를 통해 해당 값을 다시 입력받을 수 있음
- `Validator` 클래스들을 통해 유효성 검사를 진행
    - **도메인과 관련된 예외 처리는 해당 클래스에서 직접 처리**하도록 구현 ex) 플레이어 이름 형식 등
    - **입력에 대한 예외 처리는 모두 InputValidator에서 처리**하도록 구현 ex) 입력 안함 등

      → 클래스의 역할을 고려

    - 각 메서드를 작은 단위로 분리하여 재사용성 증가

## 4️⃣ 기타

### 1) Enum 활용

- Type, Option 도메인 등에서 `Enum` 을 활용해 간단하게 구현 → 상수 관리에 용이
- 게임 메시지 등 자주 사용하는 문자열을 모아 Enum 으로 구현
- 비즈니스 로직인 필요한 경우 해당 클래스에 포함

### 2) DTO

- `java record` 로 dto 클래스들을 구현했다. → 매우 간단하게 구현할 수 있어서 너무너무 좋다
- 이외에도 Controller ↔ Request 간 데이터 전달에서 dto가 아닌 Map, List 등 객체를 전달한 경우가 있었음 → 이건 그렇게 좋은 방법은 아닌 것 같다. Wrapper 클래스를 만들던, 일급 객체를 만들던 여러 방법을 고민해봐야 할 것 같음

1. 보유 잔액 정보를 담은 dto

```java
public record AccountBalanceInfoDto(long cash, Map<ChipType, Integer> chips) {
}
```

2. 룰렛 게임 베팅 정보를 담은 dto

```java
public record RouletteBetInfoDto (
        RouletteBetType betType,
        int betNumber,
        int optionNumber, Map<ChipType,
        Integer> betChips
    ) {
}
```
<br>

### 3) getter, setter 를 지양하고 객체에 메시지를 던지기

- getter 는 정말 필요한 부분이 아니면 사용하지 않고 객체에 메시지를 던지도록 구현
    - 만약 getter 를 남발한다면 캡슐화가 깨진다고 생각함
    - ex) 게임의 상태를 getter 로 가져와 종료 여부를 판단하는 것이 아닌, `isContinue` 메서드 사용

```java
public enum MainOption {
    CURRENCY_EXCHANGE("1", "환전소"),
    CASINO_GAME("2", "카지노 게임"),
    QUIT("Q", "종료");

    private final String optionNumber;
    private final String command;

    MainOption(String optionNumber, String command) {
        this.optionNumber = optionNumber;
        this.command = command;
    }

    ...

		// getter 대신 메시지를 던진다!
    public boolean isContinue() {
        return this != QUIT;
    }
}
```
- setter 는 어느 클래스에도 구현하지 않음
    - getter 보다 setter 의 사용은 캡슐화의 의미가 없어진다고 생각함
    - 클래스의 모든 멤버 변수를 `private` 으로 설정한 이유 역시 외부로부터 잘못된 변경을 막기 위해서
    - ex) 플레이어의 현금, 칩 갯수 등을 setter로 재설정하는 것이 아닌, `update` 메서드 사용

```java
public class Player extends Participant {
    private long cash;
    private final EnumMap<ChipType, Integer> chips = new EnumMap<>(ChipType.class);

    public Player(String name, RoleType roleType, long cash) {
        super(name, roleType);
        this.cash = cash;
        initializeChips();
    }

    ...

		// setter 로 cash의 값을 초기화하는 것이 아닌, update
    public void updateCash(boolean isPlus, long amount) {
        if (isPlus) {
            cash += amount;
        } else {
            cash -= amount;
        }
    }

		// setter 로 chips의 값을 초기화하는 것이 아닌, 더하기/빼기 여부에 따라 update
    public void updateChipCount(boolean isPlus, ChipType type, int count) {
        if (isPlus) {
            chips.replace(type, chips.get(type) + count);
        } else {
            chips.replace(type, chips.get(type) - count);
        }
    }
    ...
}
```
<br>

### 4) 캡슐화의 목적

- getter / setter 의 사용을 지양하는 것도 캡슐화를 지킬 수 있는 방법
- 만약 getter 사용시 불변 객체를 반환하여 외부에서 클래스의 멤버 변수 값을 잘못 변경하는 것을 방지하도록 구현 → 값을 바꾸려면 위 3) 처럼 해당 객체에서 직접 처리하도록 구현
- 실제로 `unmodifiableMap` 으로 반환하여 `chips` 의 값을 무분별하게 변경하는 것을 막을 수 있었음 (chips 정보를 가져와서 바꿔도 원본에는 영향이 없음)

```java
public class Player extends Participant {
    private long cash;
    private final EnumMap<ChipType, Integer> chips = new EnumMap<>(ChipType.class);

    public Player(String name, RoleType roleType, long cash) {
        super(name, roleType);
        this.cash = cash;
        initializeChips();
    }

    public Map<ChipType, Integer> getChipsBalance() {
        // 원본에 접근하여 변경할 수 없도록 구현해야 함 -> unmodifiable
        return Collections.unmodifiableMap(new EnumMap<>(chips));
    }
```
---

# 📌 아쉬운 점

- 객체 지향적으로 설계하는 실력이 부족하다고 생각함
- 생각보다 설계에 너무 오랜 시간을 썼음. 물론 프로그램에서 욕심나는 기능이 많아 제대로된 작업 분배를 못한 탓이지 않을까 싶음. 이러한 이유로 제일 기대했던 블랙잭과 바카라 게임은 구현하지 못함
- 불필요한 클래스가 많이 생긴 것 같다. 이 문제는 잘못된 설계때문일 확률이 크다고 생각함
- 으악 과제 구현 시간보다 정리 시간이 더 오래 걸림



