class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> result = new ArrayList();

        if (numRows == 1) {
            sub.add(1);
            result.add(sub);
            return result;
        }

        result = generate(numRows - 1);

        sub.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            sub.add(result.getLast().get(i - 1) + result.getLast().get(i));
        }
        sub.add(1);
        result.add(sub);
        return result;

    }
}