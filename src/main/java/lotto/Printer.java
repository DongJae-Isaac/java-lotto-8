package lotto;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Printer {
    private final int lottoPurchaseAmount;

    public Printer(int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public void printGeneratedLotto(List<Lotto> generatedLottos) {
        System.out.println(lottoPurchaseAmount + "개를 구매했습니다.");
        for (Lotto generatedLotto : generatedLottos) {
            List<Integer> generatedLottoNumbers = generatedLotto.getNumbers();
            System.out.println(generatedLottoNumbers);
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        Map<Rank, Integer> lottoRank = lottoResult.calculateLottoRank();
        for (Entry<Rank, Integer> rankEntry : lottoRank.entrySet()) {
            Rank rankKey = rankEntry.getKey();
            System.out.println(rankKey.getDescription() + "-" + rankEntry.getValue());
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoResult.calculateTotalYield(lottoPurchaseAmount));

    }
}
