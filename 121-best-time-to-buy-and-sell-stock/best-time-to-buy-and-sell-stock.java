class Solution {
    public int maxProfit(int[] arr) {
        int mini = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
             mini = Math.min(mini, arr[i]);
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
           
        }

        return profit;
    }
}