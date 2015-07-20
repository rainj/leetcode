package algorithms.q0001;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rainj on 7/19/15.
 */
public class Solution001 implements Solution{

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i + 1);
        }
        
        for(int i = 0; i < nums.length; i ++) {
            int num = target - nums[i];
            Integer second = map.get(num);
            if(second != null && second != i + 1) {
                result[0] = i + 1;
                result[1] = second;
                
                return result;
            }
        }
        return result;
    }

}
