package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {
    @DisplayName("구입 금액만큼 로또를 생성한다.")
    @Test
    void 구입_금액만큼_로또를_생성한다() {
        int lottoPurchaseAmount = 5000;

        LottoGenerator lottoGenerator = new LottoGenerator(lottoPurchaseAmount);
        List<Lotto> lottos = lottoGenerator.getGeneratedLotto();

        assertThat(lottos).hasSize(5);

    }

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGenerator(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGenerator(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("생성된 모든 로또 번호는 1에서 45 사이다.")
    @Test
    void 생선된_모든_로또_번호는_1에서_45_사이다() {
        LottoGenerator lottoGenerator = new LottoGenerator(5000);

        List<Lotto> generatedLotto = lottoGenerator.getGeneratedLotto();

        for (Lotto lotto : generatedLotto) {
            List<Integer> sortedNumber = lotto.getSortedNumber();
            for (Integer number : sortedNumber) {
                assertThat(number).isBetween(1, 45);
            }
        }
    }

    @DisplayName("생성된 모든 로또 번호의 개수는 6개이다.")
    @Test
    void 생성된_모든_로또_번호의_개수는_6개이다() {
        LottoGenerator lottoGenerator = new LottoGenerator(3000);

        List<Lotto> generatedLotto = lottoGenerator.getGeneratedLotto();

        for (Lotto lotto : generatedLotto) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }
}
