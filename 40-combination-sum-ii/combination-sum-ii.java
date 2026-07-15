import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int target, int[] candidates,
                           List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicate elements
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            // No need to continue if current number is too large
            if (candidates[i] > target)
                break;

            list.add(candidates[i]);

            // Move to the next index (can't reuse the same element)
            backtrack(i + 1, target - candidates[i], candidates, list, ans);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }
}