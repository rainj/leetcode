package algorithms.q0005;

/**
 * Created by rainj on 7/19/15.
 */
public class Solution002 implements Solution {
    public String longestPalindrome(String s) {
        if(null == s || s.length() == 0) {
            return "";
        }
        if(s.length() ==  1) {
            return s;
        }
        int length = s.length();
        char[] charArray = s.toCharArray();
        String result = "";

        int middleIndex = (length - 1) / 2;
        int i = middleIndex;
        while(i > result.length() / 2) {
            int leftIndex = findSameChar(charArray, charArray[i], i, length, true);
            int rightIndex = findSameChar(charArray, charArray[i], i, length, false);
            String palindrome = this.findPalindrome(charArray, leftIndex, rightIndex, length);
            if(palindrome.length() > result.length()) {
                result = palindrome;
            }
            i = leftIndex;
        }
        i = middleIndex + 1;
        while(i < length - (result.length() / 2)) {
            int leftIndex = findSameChar(charArray, charArray[i], i, length, true);
            int rightIndex = findSameChar(charArray, charArray[i], i, length, false);
            String palindrome = this.findPalindrome(charArray, leftIndex, rightIndex, length);
            if(palindrome.length() > result.length()) {
                result = palindrome;
            }
            i = rightIndex;
        }

        if(result.length() == 1) {
            return s.substring(0, 1);
        }

        return result;
    }

    int findSameChar(char[] array, char ch, int index,int length, boolean isLeft){
        int current = index;
        while (current >=0 && current < length && array[current] == ch){
            current = isLeft? current - 1 : current +  1;
        }
        return current;
    }

    String findPalindrome(char[] array, int leftIndex, int rightIndex, int length) {
        int maxHalfCount = Math.min(leftIndex + 1, length - rightIndex);
        StringBuilder strBuilder = new StringBuilder(length);
        for(int i = leftIndex + 1; i < rightIndex; i ++) {
            strBuilder.append(array[i]);
        }

        for(int i = 0; i < maxHalfCount; i++) {
            char chBefore = array[leftIndex - i];
            char chAfter = array[rightIndex + i];
            if(chBefore == chAfter) {
                strBuilder.insert(0, chBefore);
                strBuilder.append(chBefore);
            }else{
               return strBuilder.toString();
            }
        }
        return strBuilder.toString();
    }
}
