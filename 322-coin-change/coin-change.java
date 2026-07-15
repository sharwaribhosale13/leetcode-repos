import java.util.*;

// Solution class to implement tabulation approach
class Solution {
    // Function to find minimum coins
    public int coinChange(int[] coins, int amount) {
        // Creating dp array of size amount+1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: dp[0] = 0
        dp[0] = 0;

        // Loop through all amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin
            for (int coin : coins) {
                // If coin can be used
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    // Update dp[i] with minimum coins
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] is still infinity, return -1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        Solution obj = new Solution();
        System.out.println(obj.coinChange(coins, amount));
    }
}
