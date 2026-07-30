import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Traverse all bars + one extra iteration
        for (int i = 0; i <= n; i++) {

            // Current height
            int currHeight = (i == n) ? 0 : heights[i];

            // If current bar is smaller than the top of stack,
            // calculate area for taller bars
            while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {

                // Height of rectangle
                int height = heights[stack.pop()];

                int width;

                // If stack becomes empty,
                // rectangle extends from index 0 to i-1
                if (stack.isEmpty()) {
                    width = i;
                }

                // Otherwise,
                // rectangle lies between stack.peek()+1 and i-1
                else {
                    width = i - stack.peek() - 1;
                }

                // Update maximum area
                maxArea = Math.max(maxArea, height * width);
            }

            // Store current index
            stack.push(i);
        }

        return maxArea;
    }
}