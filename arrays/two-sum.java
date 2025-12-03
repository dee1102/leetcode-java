// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        int diff = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (m.containsKey(nums[i])) {
                ans[0] = m.get(nums[i]);
                ans[1] = i;
                break;
            }
            diff = target - nums[i];
            m.put(diff, i);
        }
        return ans;
    }
}

//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        int[] ans = new int[2]; // space: O(1)
//        Map<Integer, Integer> m = new HashMap<>(); // space: O(n)
//        int[] diffs = new int[nums.length]; // space: O(n)
//        for (int i = 0; i < nums.length ; i++) { // O(n)
//            diffs[i] = target - nums[i]; // O(1)
//            m.put(nums[i], i); // O(1) amortized
//        }
//
//        for (int i = 0; i < nums.length ; i++) { // O(n)
//            if (m.get(diffs[i]) != null && m.get(diffs[i]) != i) {
//                ans[0] = i;
//                ans[1] = m.get(diffs[i]);
//                break;
//            }
//        }
//        return ans;
//    }
//}