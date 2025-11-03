package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private List<Integer> winningLotto;

    public WinningLotto(String input) {
        String removedBlank = removeBlank(input);
        String[] lottoNum = removedBlank.split(",");
        List<Integer> parsedNumber = parseStringToInteger(lottoNum);
        validate(parsedNumber);

        this.winningLotto = List.copyOf(parsedNumber);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> parseStringToInteger(String[] lottoNum) {
        List<Integer> lottoList = new ArrayList<>();
        for (String lotto : lottoNum) {
            try {
                lottoList.add(Integer.parseInt(lotto));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_NUMBER.getMessage());
            }
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
