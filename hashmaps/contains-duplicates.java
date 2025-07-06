// iteration 1

// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> keyNums = new HashMap<>(); // use a hashset instead

        for (int i = 0; i < nums.length; i++) {
            if (keyNums.containsKey(nums[i])) {
                return true;
            } else {
                keyNums.put(nums[i], i); // O(n)
            }
        }
        return false;
    }
}