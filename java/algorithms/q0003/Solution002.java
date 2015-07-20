package algorithms.q0003;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rainj on 7/19/15.
 */
public class Solution002 implements Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int maxCount = 0;
        char[] charArray = s.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i ++ ) {
            int index = strBuilder.indexOf(String.valueOf(charArray[i]));
            if(index >= 0) {
                int count = strBuilder.length();
                strBuilder = new StringBuilder().append(strBuilder.substring(index + 1, count));
                maxCount = count > maxCount ? count : maxCount;
            }
            strBuilder.append(charArray[i]);
        }
        maxCount = strBuilder.length() > maxCount ? strBuilder.length(): maxCount;
        return maxCount;
    }
}
