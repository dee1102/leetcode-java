class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0;
        int drink = 0;
        if (numBottles < numExchange) {
            return numBottles;
        }
        while (numBottles != 0 || empty != 0) {
            if (numBottles > 0) {
                drink += numBottles;
                empty += numBottles;
                numBottles = 0;
            }
            if (numBottles == 0 && empty > 0) {
                numBottles = empty / numExchange;
                empty = empty % numExchange;
            }
            if (numBottles == 0 && (empty < numExchange || empty == 0)) {
                break;
            }
        }
        return drink;
    }
}