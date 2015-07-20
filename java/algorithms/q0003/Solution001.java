package algorithms.q0003;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rainj on 7/19/15.
 */
public class Solution001 implements Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] charArray = s.toCharArray();
        int length = s.length();
        Set set = new HashSet();
        int maxCount = 0;
        for(int i = 0;  i < length; i ++) {
            for(int j = i; j < length; j ++) {
                if(set.contains(charArray[j])) {
                    break;
                }
                set.add(charArray[j]);
            }
            maxCount = set.size() > maxCount ? set.size() : maxCount;
            set.clear();
        }
        return maxCount;
    }
}
