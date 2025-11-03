package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Lotto> lottos;
    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public LottoResult(List<Lotto> generatedLotto, List<Integer> winningLotto, int bonusNumber) {
        this.lottos = generatedLotto;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    /*
    *
    @return 로또의 순위와 갯수가 담겨져 있는 enum
    */
    public Map<Rank, Integer> calculateLottoRank() {
        Map<Rank, Integer> lottoRank = initializeRank();

        for (Lotto lotto : lottos) {
            int matchCounts = calculateLottoMatch(lotto);
            boolean hasBonus = hasBonusNumber(lotto);

            Rank rank = determineRank(matchCounts, hasBonus);
            if (rank != null) {
                int currentCount = lottoRank.get(rank);
                lottoRank.put(rank, currentCount + 1);
            }
        }
        return lottoRank;
    }

    // 총 당첨금 구하기
    public double calculateTotalPrize() {
        Map<Rank, Integer> ranks = calculateLottoRank();
        long totalPrize = 0;

        for (Rank rank : ranks.keySet()) {
            int count = ranks.get(rank);
            long prize = rank.getPrize();
            totalPrize += count * prize;
        }
        return totalPrize;
    }

    public double calculateTotalYield(int lottoPurchaseAmount) {
        return (calculateTotalPrize()/ lottoPurchaseAmount) * 100;
    }

    private Rank determineRank(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return Rank.FIRST;
        if (matchCount == 5 && hasBonus) return Rank.SECOND;
        if (matchCount == 5) return Rank.THIRD;
        if (matchCount == 4) return Rank.FOURTH;
        if (matchCount == 3) return Rank.FIFTH;
        return null;
    }

    // 각 로또 번호 일치 개수 계산
    private int calculateLottoMatch(Lotto lotto) {
        List<Integer> lottoNumber = lotto.getNumbers();
        int count = 0;
        for (Integer lottoNum : lottoNumber) {
            if(winningLotto.contains(lottoNum)) {
                count++;
            }
        }
        return count;
    }

    // 보너스 번호 포함 여부
    private boolean hasBonusNumber(Lotto lotto) {
        List<Integer> lottoNumber = lotto.getNumbers();
        return lottoNumber.contains(bonusNumber);
    }


    private Map<Rank, Integer> initializeRank() {
        Map<Rank, Integer> rank = new HashMap<>();
        rank.put(Rank.FIRST, 0);
        rank.put(Rank.SECOND, 0);
        rank.put(Rank.THIRD, 0);
        rank.put(Rank.FOURTH, 0);
        rank.put(Rank.FIFTH, 0);

        return rank;
    }


}
