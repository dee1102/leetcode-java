// O(n2) and O(1)
// to be improved
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = i + 1, swapped = 0;
        while (i < (nums.length - swapped) && j < (nums.length - swapped)) {
            if (nums[i] == nums[j]) {
                if (j - i == 1) {
                    j++;
                } else if (j - i == 2) {
                    // start swapping
                    while (j < nums.length - 1 - swapped) {
                        nums[j] = nums[j+1];
                        j++;
                    }
                    swapped++;
                    j = i + 2;
                }
            } else {
                i = j;
                j++;
            }
        }
        return nums.length - swapped;
    }
}