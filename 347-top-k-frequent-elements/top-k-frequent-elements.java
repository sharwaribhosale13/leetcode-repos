import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Count frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Bucket array: index = frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // Put numbers into their frequency bucket
        for (int num : map.keySet()) {

            int freq = map.get(num);

            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();

            bucket[freq].add(num);
        }

        int[] ans = new int[k];
        int index = 0;

        // Traverse buckets from highest frequency
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {

                    ans[index++] = num;

                    if (index == k)
                        break;
                }
            }
        }

        return ans;
    }
}