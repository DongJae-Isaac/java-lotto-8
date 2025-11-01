package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private final List<Lotto> generatedLottos;

    public LottoGenerator(int lottoPurchaseAmount){
        int lottoAmount = calculateLottoCount(lottoPurchaseAmount);
        this.generatedLottos = createLotto(lottoAmount);
    }

    private List<Lotto> createLotto(int lottoAmount) {
        List<Lotto> lotto = new ArrayList<>();
        for(int i = 0; i < lottoAmount; i++) {
            List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            lotto.add(new Lotto(lottoNum));
        }
        return lotto;
    }

    public int calculateLottoCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount/1000;
    }

    public List<Lotto> getGeneratedLotto(){
        return List.copyOf(generatedLottos);
    }
}
