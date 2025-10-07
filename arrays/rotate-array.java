// time complexity saved
// to save space - use the reversal logic
import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        // if (k == 0) {return;}
        int shift = nums.length - k%nums.length;
        int[] temp2 = new int[shift];
        int[] temp1 = new int[k%nums.length];
        System.arraycopy(nums, 0, temp2, 0, shift);
        System.arraycopy(nums, shift, temp1, 0, k%nums.length);
        System.arraycopy(temp1, 0, nums, 0, temp1.length);
        System.arraycopy(temp2, 0, nums, temp1.length, temp2.length);

    }
}