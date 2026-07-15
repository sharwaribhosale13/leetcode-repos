import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int target, int[] candidates,
                           List<Integer> list, List<List<Integer>> ans) {

        // Target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Out of bounds or target becomes negative
        if (index == candidates.length || target < 0) {
            return;
        }

        // Pick current element
        list.add(candidates[index]);
        backtrack(index, target - candidates[index], candidates, list, ans);

        // Backtrack
        list.remove(list.size() - 1);

        // Don't pick current element
        backtrack(index + 1, target, candidates, list, ans);
    }
}