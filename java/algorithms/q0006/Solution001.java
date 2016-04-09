package algorithms.q0006;

/**
 * Created by rainj on 7/20/15.
 */
public class Solution001 implements Solution{
    public String convert(String s, int numRows) {
        int numberPerColumn = numRows * 2 - 2;
        if(numberPerColumn <= 0) {
            return s;
        }

        int moreCharCount = s.length() % numberPerColumn;
        int column = moreCharCount > 0 ? s.length() / numberPerColumn + 1 : s.length() / numberPerColumn;

        int gap;
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < numRows; i ++) {
            for(int j = 0; j < column; j ++) {
                int index = j * numberPerColumn + i;
                if(index >= s.length()) {
                    break;
                }
                strBuilder.append(s.charAt(index));

                gap = numberPerColumn - 2 * i;

                if(gap > 0 && gap < numberPerColumn && index + gap < s.length()) {
                    strBuilder.append(s.charAt(index + gap));
                }

            }
        }
        return strBuilder.toString();
    }
}
