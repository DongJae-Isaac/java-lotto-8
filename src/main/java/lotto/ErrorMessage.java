package lotto;

public enum ErrorMessage {
    PURCHASE_NOT_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    PURCHASE_NOT_POSITIVE("[ERROR] 구입 금액은 1,000원 이상이어야 합니다."),
    PURCHASE_NOT_UNIT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),

    LOTTO_NUMBER_SIZE("[ERROR] 로또 번호는 6개이어야 합니다."),
    LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),

    WINNING_NUMBER_SIZE("[ERROR] 당첨 번호는 6개이어야 합니다."),
    WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_NOT_NUMBER("[ERROR] 당첨 번호는 숫자여야 합니다."),

    BONUS_NUMBER_NOT_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
