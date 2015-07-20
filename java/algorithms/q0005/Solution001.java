package algorithms.q0005;

/**
 * Created by rainj on 7/19/15.
 */
public class Solution001 implements Solution {
    public String longestPalindrome(String s) {
        if(null == s || s.length() == 0) {
            return "";
        }
        char[] charArr = s.toCharArray();
        int length = charArr.length;
        String result = "";
        StringBuilder strBuilder = new StringBuilder(length);
        int maxLen = 0;
        for(int i = 0; i < length; i ++) {
            for(int j = length; j > i + 1; j --){
                if(isPalindrome(charArr, i, j)){
                    strBuilder.append(charArr, i, j - i);
                    break;
                }
            }
            if(strBuilder.length() > result.length()) {
                result = strBuilder.toString();
            }
            strBuilder.delete(0, strBuilder.length());
        }

        return result;
    }

    boolean isPalindrome(char[] array, int start, int end) {
        if(end <= start) {
            return false;
        }
        int halfLength = (end - start) / 2;
        for(int i = 0; i < halfLength; i ++ ) {
            if(array[start + i] != array[end - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
