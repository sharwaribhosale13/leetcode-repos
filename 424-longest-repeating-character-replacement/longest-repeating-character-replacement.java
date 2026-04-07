class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurances = new int[26];
        int left = 0;
        int ans = 0;
        int maxoccurances = 0;

        for (int right = 0; right < s.length(); right++) {

            maxoccurances = Math.max(
                maxoccurances,
                ++occurances[s.charAt(right) - 'A']
            );

            if (right - left + 1 - maxoccurances > k) {
                occurances[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}