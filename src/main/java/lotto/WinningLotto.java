package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningLotto;

    public WinningLotto(String input) {
        String removedBlank = removeBlank(input);
        String[] lottoNum = removedBlank.split(",");
        this.winningLotto = parseStringToInteger(lottoNum);
    }

    public List<Integer> parseStringToInteger(String[] lottoNum) {
        List<Integer> lottoList = new ArrayList<>();
        for (String lotto : lottoNum) {
            lottoList.add(Integer.parseInt(lotto));
        }
        return lottoList;
    }

    public String removeBlank(String input) {
        return input.replace(" ", "");
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }
}
