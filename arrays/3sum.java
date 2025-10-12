
// time limit exceeded
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> sums = new ArrayList<>();
        int i = 0, j = i + 1;
        while ( i < list.size() - 2) {
            int diff = list.get(i) + list.get(j);
            final int currentI = i;
            final int currentJ = j;

            int k = IntStream.range(0, list.size())
                    .filter(x -> list.get(x) != null && list.get(x) == diff * -1 && x > currentI && x > currentJ)
                    .findFirst()
                    .orElse(-1);

            if (k != -1) {
                List<Integer> sub = Arrays.asList(list.get(i), list.get(j), list.get(k));
                Collections.sort(sub);
                if (!sums.contains(sub)) {
                    sums.add(sub);
                }
            }

            if (j == list.size() - 1) {
                i++;
                j = i + 1;
            } else {
                j++;
            }
        }
        return sums;
    }
}