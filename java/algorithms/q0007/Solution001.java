package algorithms.q0007;

/**
 * Created by rjiang on 3/2/16.
 */
public class Solution001 implements Solution {

    @Override
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isPositive = true;
        long number = x;
        if (x < 0) {
            isPositive = false;
            number = -number;
        }
        StringBuilder stringBuilder = new StringBuilder().append(number);
        long result = Long.parseLong(stringBuilder.reverse().toString());
        if(result > Integer.MAX_VALUE) {
            result = 0;
        }
        return isPositive ? (int)result : -(int)result;
    }
}
