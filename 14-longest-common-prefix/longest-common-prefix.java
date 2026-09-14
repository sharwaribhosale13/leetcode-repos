import java.util.Arrays;

class Solution {
    // Returns the longest common prefix in an array of strings
    public String longestCommonPrefix(String[] v) {
        // To store the result prefix
        StringBuilder ans = new StringBuilder();

        // Sort the array of strings
        Arrays.sort(v);

        // First string after sorting
        String first = v[0];

        // Last string after sorting
        String last = v[v.length - 1];

        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // Stop if characters are different
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }

            // Add matching character to result
            ans.append(first.charAt(i));
        }

        // Return the final common prefix
        return ans.toString();
    }
}

