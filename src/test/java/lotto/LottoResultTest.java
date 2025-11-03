package lotto;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("일등 당첨을 확인.")
    @Test
    void 일등_당첨을_확인() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        Map<Rank, Integer> rank = result.calculateLottoRank();

        assertThat(rank.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("이등 당첨을 확인.")
    @Test
    void 이등_당첨을_확인() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8;

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        Map<Rank, Integer> rank = result.calculateLottoRank();

        assertThat(rank.get(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("당첨되지 않은 경우를 확인.")
    @Test
    void 당첨되지_않은_경우를_확인() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 9, 10, 11)));
        List<Integer> winningNumbers = List.of(3, 4, 5, 6, 7, 8);
        int bonusNumber = 12;

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        Map<Rank, Integer> rank = result.calculateLottoRank();

        assertThat(rank.get(Rank.FIRST)).isEqualTo(0);
        assertThat(rank.get(Rank.SECOND)).isEqualTo(0);
        assertThat(rank.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rank.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rank.get(Rank.FIFTH)).isEqualTo(0);
    }
}
