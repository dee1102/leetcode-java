class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // pruning: stop early when remaining numbers < needed
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path);
            path.remove(path.size() - 1);
        }
    }
}

// mine
//class Solution {
//    List<List<Integer>> result = new ArrayList<>();
//    int orgK = 0;
//
//    public List<List<Integer>> combine(int n, int k) {
//
//        if (k > n) {
//            return result;
//        }
//        orgK = k;
//        for (int i = 1; i <= n - k + 1; i++) {
//            List<Integer> sub = new ArrayList<Integer>();
//            // System.out.println(sub);
//            dfs(i, k, n, sub);
//        }
//        return this.result;
//    }
//    public void dfs(int i, int k, int n, List<Integer> sub) {
//        sub.add(i);
//        // System.out.println(">> x");
//        // System.out.println(sub);
//        if (i <= n && k == 1 && orgK == sub.size()) {
//            // System.out.println("---in return");
//            this.result.add(new ArrayList<>(sub));
//            sub.remove(sub.size() - 1);
//            return;
//        }
//
//
//        for (int j = 1; j <= n - k + 1 && i + j <= n; j++) { // k + 1
//            dfs(i+j, k-1, n, sub);
//            // System.out.println(">> y");
//            // System.out.println(sub);
//            // System.out.println(j);
//        }
//        sub.remove(sub.size() - 1);
//        // System.out.println(">> z");
//        // System.out.println(sub);
//    }
//}
