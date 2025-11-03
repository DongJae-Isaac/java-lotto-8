package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        int lottoPurchaseAmount = input.getLottoPurchaseAmount();

        Printer printer = new Printer(lottoPurchaseAmount);
        // 로또 생성
        LottoGenerator lottoGenerator = new LottoGenerator(lottoPurchaseAmount);
        List<Lotto> generatedLottos = lottoGenerator.getGeneratedLotto();
        // 생성한 로또 출력
        printer.printGeneratedLotto(generatedLottos);

        String lottoNumber = input.getLottoNumber();
        int bonusNumber = input.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(lottoNumber);
        List<Integer> winningLottoNum = winningLotto.getWinningLotto();

        // 로또 결과 출력
        LottoResult lottoResult = new LottoResult(generatedLottos, winningLottoNum, bonusNumber);
        printer.printLottoResult(lottoResult);
    }
}
