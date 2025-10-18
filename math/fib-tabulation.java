class Solution {
    public int fib(int n) {
        int prev = 0;
        int result = 1;

        if (n < 2) {
            result = n;
        } else {
            int i = 2;
            while (i <= n) {
                int temp = result;
                result = result + prev;
                prev = temp;
                i++;
            }
        }
        return result;
    }
}