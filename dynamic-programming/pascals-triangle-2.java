class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> sub = new ArrayList<>();

        if (rowIndex == 0) {
            sub.add(1);
            return sub;
        }

        List<Integer> result = new ArrayList();
        result = getRow(rowIndex - 1);

        sub.add(1);
        for (int i = 0; i < rowIndex - 1; i++) {
            sub.add(result.get(i) + result.get(i + 1));
        }
        sub.add(1);
        return sub;
    }
}