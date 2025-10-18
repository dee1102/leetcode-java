// leetcode
public boolean divisorGame(int n) {
    // dp[i] = true if current player can win with i remaining on chalkboard
    boolean[] dp = new boolean[n + 1];

    // Base case: n = 1 (no valid move → current player loses)
    dp[1] = false;

    // Fill dp[2] to dp[n]
    for (int i = 2; i <= n; i++) {
        // Try all valid divisors x (0 < x < i, and i % x == 0)
        for (int x = 1; x < i; x++) {
            if (i % x == 0) {
                // If we can force opponent into a losing state (dp[i - x] = false)
                if (!dp[i - x]) {
                    dp[i] = true; // Current player wins
                    break; // No need to check other x
                }
            }
        }
    }
    return dp[n];
}