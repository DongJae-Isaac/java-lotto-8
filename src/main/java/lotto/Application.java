package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        int lottoPurchaseAmount = Integer.parseInt(input.getLottoPurchaseAmount());
        String lottoNumber = input.getLottoNumber();
        int bonusNumber = Integer.parseInt(input.getBonusNumber());

        WinningLotto winningLotto = new WinningLotto(lottoNumber);
        List<Integer> winningLottoNum = winningLotto.getWinningLotto();

        LottoGenerator lottoGenerator = new LottoGenerator(lottoPurchaseAmount);
        List<Lotto> generatedLottos = lottoGenerator.getGeneratedLotto();



        LottoResult lottoResult = new LottoResult(generatedLottos, winningLottoNum, bonusNumber);
        System.out.println(lottoResult.calculateTotalPrize());
    }
}
