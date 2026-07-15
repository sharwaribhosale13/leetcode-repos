import java.util.*;

class Solution {

    public String getPermutation(int n, int k) {

        List<Integer> nums = new ArrayList<>();
        int fact = 1;

        // Store numbers 1 to n and calculate (n-1)!
        for (int i = 1; i <= n; i++) {
            nums.add(i);

            if (i < n)
                fact *= i;
        }

        k--;    // Convert to 0-based indexing

        StringBuilder ans = new StringBuilder();

        while (!nums.isEmpty()) {

            int index = k / fact;

            ans.append(nums.get(index));

            nums.remove(index);

            if (nums.isEmpty())
                break;

            k = k % fact;

            fact = fact / nums.size();
        }

        return ans.toString();
    }
}