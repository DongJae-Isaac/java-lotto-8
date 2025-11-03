package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int getLottoPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input =  Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_NOT_NUMBER.getMessage());
        }
    }

    public String getLottoNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_NUMBER.getMessage());
        }
    }
}
