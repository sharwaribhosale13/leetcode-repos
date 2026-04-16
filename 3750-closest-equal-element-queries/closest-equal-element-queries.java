import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: store indices of each number
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: process each query
        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // if only one occurrence
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            // Step 3: binary search to find position of q in list
            int idx = Collections.binarySearch(list, q);

            int m = list.size();

            // previous index (circular)
            int prev = list.get((idx - 1 + m) % m);

            // next index (circular)
            int next = list.get((idx + 1) % m);

            // Step 4: compute circular distances
            int distPrev = Math.min(Math.abs(q - prev), n - Math.abs(q - prev));
            int distNext = Math.min(Math.abs(q - next), n - Math.abs(q - next));

            result.add(Math.min(distPrev, distNext));
        }

        return result;
    }
}