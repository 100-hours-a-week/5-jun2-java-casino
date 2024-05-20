package casino.io.game;

public enum GameInputMessage {
    REQUEST_GAME_MESSAGE("참여를 원하는 게임을 선택하세요."),
    REQUEST_SLOT_MACHINE_PAYMENT("슬롯 머신 1회 결제 금액은 5,000원 입니다. 결제하시겠습니까? [Y/N]"),
    REQUEST_ROULETTE_CHIP("%s 게임에 베팅할 칩 개수를 쉼표(,)로 구분하여 입력해주세요. ex) 1, 0, 2, 0, 0, 0"),
    REQUEST_ROULETTE_BET_TYPE("베팅 옵션을 선택해주세요. 옵션별로 배당금이 다릅니다."),
    REQUEST_RETRY_GAME("다시 플레이 하시겠습니까? [Y/N]"),
    CONSOLE_SYMBOL(">> "),
    REQUEST_ROULETTE_ONE_NUMBER("0 ~ 36 까지의 숫자 중 하나에 베팅해주세요."),
    REQUEST_ROULETTE_NOT_MULTIPLY_OF_3("0 ~ 36 까지의 숫자 중 3의 배수가 아닌 숫자 하나에 베팅해주세요. ex) 2, 23, 31, 35"),
    REQUEST_ROULETTE_STREET_BET("0 ~ 36 까지의 숫자 중 3으로 나눈 나머지가 1인 숫자 하나에 베팅해주세요. ex) 1, 19, 16, 19"),
    REQUEST_THREE_OPTIONS("1, 2, 3 중 베팅하고자 하는 옵션을 숫자로 입력해주세요."),
    REQUEST_TWO_OPTIONS("1, 2 중 베팅하고자 하는 옵션을 숫자로 입력해주세요.");

    private String message;

    GameInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
