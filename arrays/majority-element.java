// O(n) and O(1)


// O(n) and O(n)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        for (int n: nums) {
            if (counterMap.containsKey(n)) {
                counterMap.put(n, counterMap.get(n) + 1);
            } else {
                counterMap.put(n, 1);
            }
        }
        int condition = (int) Math.floor(nums.length/2);
        int result = 0;

        for (int key : counterMap.keySet()) {
            if (counterMap.get(key) > condition) {
                result = key;
                break;
            }
        }
        return result;
    }
}

