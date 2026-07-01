import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        long size = (long) n * n;   // Total numbers = n²

        // Expected sum of numbers from 1 to n²
        long SN = (size * (size + 1)) / 2;

        // Expected sum of squares from 1 to n²
        long S2N = (size * (size + 1) * (2 * size + 1)) / 6;

        long S = 0;
        long S2 = 0;

        // Calculate actual sum and sum of squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                S += grid[i][j];
                S2 += (long) grid[i][j] * grid[i][j];
            }
        }

        // X - Y
        long val1 = S - SN;

        // X² - Y²
        long val2 = S2 - S2N;

        // X + Y
        val2 = val2 / val1;

        // Repeated number
        long x = (val1 + val2) / 2;

        // Missing number
        long y = x - val1;

        return new int[]{(int) x, (int) y};
    }
}