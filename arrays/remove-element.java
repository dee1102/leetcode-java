class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i != j && i < j) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    j--;
                } else {
                    nums[i] = nums[j];
                    i++;
                    j--;
                }
            } else {
                i++;
            }
        }
        if (nums[j] == val) {
            return j;
        }
        return j+1;
    }
}