import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_INVERSIONS = 400;

    public int numberOfPermutations(int n, int[][] requirements) {

        Map<Integer, Integer> reqMap = new HashMap<>();
        for (int[] req : requirements) {
            reqMap.put(req[0] + 1, req[1]);
        }


        long[][] permCounts = new long[n + 1][MAX_INVERSIONS + 1];
        permCounts[0][0] = 1;

        for (int length = 1; length <= n; length++) {
            for (int inv = 0; inv <= MAX_INVERSIONS; inv++) {
                for (int newPos = 0; newPos < length; newPos++) {
                    int prevInv = inv - newPos;
                    if (prevInv >= 0) {
                        permCounts[length][inv] = (permCounts[length][inv] + permCounts[length - 1][prevInv]) % MOD;
                    }
                }
            }


            if (reqMap.containsKey(length)) {
                int targetInv = reqMap.get(length);
                for (int inv = 0; inv <= MAX_INVERSIONS; inv++) {
                    if (inv != targetInv) {
                        permCounts[length][inv] = 0;
                    }
                }
            }
        }


        long result = 0;
        for (long count : permCounts[n]) {
            result = (result + count) % MOD;
        }

        return (int) result;
    }
}