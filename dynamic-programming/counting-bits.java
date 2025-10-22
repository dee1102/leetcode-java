class Solution {
    int[] memo = null;

    public int[] countBits(int n) {
        memo = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (memo[n] != 0) {
                continue;
            }
            memo[i] = cB(i);

        }
        return memo;
    }

    public int cB(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n == 1) {
            memo[1] = 1;
            return 1;
        }
        int current = 0;
        if (n % 2 == 1) {
            current = 1 + cB(n/2);
        } else {
            current = cB(n/2);
        }
        return current;
    }
}