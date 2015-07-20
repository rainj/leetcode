package algorithms.q0004;

/**
 * Created by rainj on 7/19/15.
 */
public class Solution001 implements Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int median = (m + n - 1) / 2;
        int index = 0;
        int currentMIndex = 0;
        int currentNIndex = 0;
        boolean isMSelected = true;
        while(index <= median) {
            if(currentMIndex >= m) {
                median = median - index + currentNIndex;
                return (m + n) % 2 == 0 ? (nums2[median] + nums2[median + 1])/2.0  : nums2[median];
            }
            if(currentNIndex >= n) {
                median = median - index + currentMIndex;
                return (m + n) % 2 == 0 ? (nums1[median] + nums1[median + 1])/2.0  : nums1[median];
            }

            if(nums1[currentMIndex] < nums2[currentNIndex]){
                currentMIndex ++;
                isMSelected = true;
            }else {
                currentNIndex ++;
                isMSelected = false;
            }
            index ++;

        }

        double result = isMSelected ? nums1[currentMIndex - 1] : nums2[currentNIndex - 1];

        if((m + n) % 2 == 0) {
            double sum = result;
            if(currentMIndex >= m) {
                sum += nums2[currentNIndex];
            } else if(currentNIndex >= n) {
                sum += nums1[currentMIndex];
            } else {
                sum += nums1[currentMIndex] > nums2[currentNIndex] ? nums2[currentNIndex] : nums1[currentMIndex];
            }
            result = sum / 2.0;
        }

        return result;
    }
}
