package algorithms.q0066;

/**
 * Created by rjiang on 3/30/16.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int currentNumber = digits[length - 1];
        currentNumber++;
        for (int i = length - 1; i > 0; i--) {
            digits[i] = currentNumber % 10;
            currentNumber = digits[i - 1] + currentNumber / 10;
            if (currentNumber == digits[i - 1]) {
                return digits;
            }
        }
        digits[0] = currentNumber % 10;
        int firstNumber = currentNumber / 10;
        if (firstNumber == 0) {
            return digits;
        }
        int[] result = new int[length + 1];
        result[0] = firstNumber;
        for (int i = 0; i < length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}