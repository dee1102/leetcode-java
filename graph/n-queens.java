// first iteration

class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<List<String>> result = new HashSet<>();
        traverse(0, new ArrayList<>(), result, n);
        return new ArrayList<>(result);
    }

    public void traverse(int x, List<List<Integer>> path, Set<List<String>> result, int n) {
        // System.out.println("---------> start");
        // base case
        if (path.size() == n) {

            List<String> res = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder b = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (path.get(i).get(1) == j) {
                        b.append("Q");`
                    } else {
                        b.append(".");
                    }
                }
                res.add(b.toString());

            }
            if (!result.contains(res)) {
                result.add(res);
            }
            System.out.println("---------> result " + result.toString());
            return;
        }


        for (int y = 0; y < n; y++) {
            // check choice validity
            // System.out.println("---------> pre pre path " + path.toString());

            boolean prune = false;
            for (List<Integer> p: path) {
                int px = p.get(0), py = p.get(1);
                if ( py == y || Math.abs(px - x) == Math.abs(py - y)){
                    prune = true;
                    break;
                }
            }

            if (prune) continue;

            path.add(Arrays.asList(x, y));
            // System.out.println("---------> pre path " + path.toString());

            traverse(x+1, path, result, n);

            path.remove(path.size() - 1);
            // System.out.println("---------> post path " + path.toString());

        }
        // System.out.println("---------> end");
    }
}