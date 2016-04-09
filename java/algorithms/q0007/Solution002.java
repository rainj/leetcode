package algorithms.q0007;

/**
 * Created by rjiang on 3/2/16.
 */
public class Solution002 implements Solution {
    @Override
    public int reverse(int x) {
        if(x == 0) {
            return 0;
        }

        if(x == Integer.MIN_VALUE) {
            return 0;
        }


        boolean isPositive = x > 0;
        int number = isPositive ? x : -x;
        int bit = (int)Math.log10(number);

        if(bit == 9 && number%10 > 2) {
            return 0;
        }

        int firstBit = number % 10;
        int result = firstBit * (int)Math.pow(10, bit);
        for(int i = 1; i <= bit; i ++) {
            int n = (number / (int)Math.pow(10, i)) % 10;
            int value = n * (int)Math.pow(10, bit - i);
            if(Integer.MAX_VALUE - result >= value) {
                result += value;
            }else {
                return 0;
            }
        }

        return isPositive ? result : -result;
    }
}
