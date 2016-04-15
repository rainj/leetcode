package algorithms.q0008;

/**
 * Created by rjiang on 3/2/16.
 */
public class Solution001 implements Solution{
    @Override
    public int myAtoi(String str) {
    	String numberStr = str;
    	if(isEmpty(numberStr)) {
    		return 0;
    	}
    	char firstChar = numberStr.charAt(0);
    	boolean isPositive = true;
    	if(isSignedSymbole(firstChar)) {
    		isPositive = this.isPositive(firstChar);
    		numberStr = numberStr.substring(1);
    	}
        if(isEmpty(numberStr)) {
        	return 0;
        }
        
        
        

        return 0;
    }
    
    public boolean isEmpty(String str) {
    	return null == str || 0 == str.length();
    }
    
    public boolean isNumber(char ch) {
    	return ch <= '9' && ch >= '0';
    }
    
    public boolean isSignedSymbole(char ch) {
    	return ch == '-' || ch == '+';
    }
    
    public boolean isPositive(char ch) {
    	return ch != '-';
    }
    
}
