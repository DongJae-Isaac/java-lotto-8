    package lotto;

    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

    public class Lotto {
        private static final int LOTTO_NUMBER_SIZE = 6;
        private static final int MIN_LOTTO_NUMBER = 1;
        private static final int MAX_LOTTO_NUMBER = 45;
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            validateSize(numbers);
            validateRange(numbers);
            validateDuplicate(numbers);
            this.numbers = numbers;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        private void validateSize(List<Integer> numbers) {
            if (numbers.size() != LOTTO_NUMBER_SIZE) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE.getMessage());
            }
        }

        private void validateRange(List<Integer> numbers) {
            for (Integer number : numbers) {
                if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                    throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
                }
            }
        }

        private void validateDuplicate(List<Integer> numbers) {
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            if(uniqueNumbers.size() != LOTTO_NUMBER_SIZE) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
            }
        }
    }
