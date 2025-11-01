package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getLottoPurchaseAmount(){
        System.out.println("구입 금액을 입력해주세요.");
        return Console.readLine();
    }

    public String getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
