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
        int LOTTO_PRICE = 1000;
        System.out.println(lottoPurchaseAmount/ LOTTO_PRICE + "개를 구매했습니다.");
        for (Lotto generatedLotto : generatedLottos) {
            System.out.println(generatedLotto.getSortedNumber());
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        Map<Rank, Integer> lottoRank = lottoResult.calculateLottoRank();

        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            int count = lottoRank.getOrDefault(rank, 0);
            System.out.println(rank.getDescription() + " - " + count + "개");
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoResult.calculateTotalYield(lottoPurchaseAmount));

    }
}
