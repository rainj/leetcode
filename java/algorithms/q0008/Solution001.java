package algorithms.q0008;

/**
 * Created by rjiang on 3/2/16.
 */
public class Solution001 implements Solution{
    @Override
    public int myAtoi(String str) {
        int len = str.length();
        if(len == 0) {
            return 0;
        }

        boolean isPositive = str.charAt(0) - '-' != 0;
        int result;
        if(isPositive) {
            if(len > 9 || (len == 9 && str.charAt(0) - '2' > 0)) {
                return 0;
            }
        }else {
            if(len > 10 || (len == 10 && str.charAt(1) - '2' > 0)) {
                return 0;
            }
        }
        for(int i = 0; i < len; i ++) {
            if(!isPositive) {
                
                continue;
            }
            char ch = str.charAt(i);
//            boolean isPositive =
            int gap = ch - '0';
        }


        return 0;
    }
}
