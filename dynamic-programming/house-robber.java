class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        if (memo.containsKey(nums.length + 1)) {
            return memo.get(nums.length + 1);
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            memo.put(nums.length + 1, Math.max(nums[0], nums[1]));
            return memo.get(nums.length + 1);
        }

        memo.put(nums.length + 1, Math.max(nums[0] + rob(Arrays.copyOfRange(nums, 2, nums.length)), rob(Arrays.copyOfRange(nums, 1, nums.length))));
        return memo.get(nums.length + 1);
    }
}
// could be done with suffix or prefix