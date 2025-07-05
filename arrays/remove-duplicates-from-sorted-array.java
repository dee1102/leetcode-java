// time complexity: O(n)
// space complexity: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int currentValue = nums[nums.length - 1];
        for (int i = nums.length - 2; i > -1 ; i--) {
            if (nums[i] == currentValue) {
                nums[i+1] = -101;
            }
            if (nums[i] < currentValue) {
                currentValue = nums[i];
                j++;
            }
            if (i+2 < nums.length && nums[i+1] == -101) {
                nums[i+1] = nums[i+2];
                nums[i+2] = -101;
            }
        }
        int x = 0;
        int y = 1;
        while (y < nums.length && x < nums.length) {
            if (nums[x] != -101) {
                x++;
                y++;
                continue;
            }
            if (nums[x] == -101) {
                if (nums[y] != -101) {
                    nums[x] = nums[y];
                    nums[y] = -101;
                    x++;
                }
                y++;
            }
        }
        return j;
    }
}

// Better solution
//class Solution {
//    public int removeDuplicates(int[] nums) {
//        if (nums.length == 0) return 0;
//
//        int i = 0;  // pointer to place unique elements
//
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//
//        return i + 1;  // length = last unique index + 1
//    }
//}
