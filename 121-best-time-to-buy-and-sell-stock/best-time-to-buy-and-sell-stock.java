class Solution {
    public int maxProfit(int[] arr) {
        int mini = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }

        return profit;
    }
}