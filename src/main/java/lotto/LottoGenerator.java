package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> generatedLottos;

    public LottoGenerator(int lottoPurchaseAmount){
        validatePurchaseAmount(lottoPurchaseAmount);
        int lottoAmount = calculateLottoCount(lottoPurchaseAmount);
        this.generatedLottos = createLotto(lottoAmount);

    }

    private void validatePurchaseAmount(int lottoPurchaseAmount) {
        if(lottoPurchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_NOT_POSITIVE.getMessage());
        }

        if(lottoPurchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_NOT_UNIT.getMessage());
        }
    }

    private List<Lotto> createLotto(int lottoAmount) {
        List<Lotto> lotto = new ArrayList<>();
        for(int i = 0; i < lottoAmount; i++) {
            List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNum);
            lotto.add(new Lotto(lottoNum));
        }
        return lotto;
    }

    public int calculateLottoCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount/LOTTO_PRICE;
    }

    public List<Lotto> getGeneratedLotto(){
        return List.copyOf(generatedLottos);
    }
}
