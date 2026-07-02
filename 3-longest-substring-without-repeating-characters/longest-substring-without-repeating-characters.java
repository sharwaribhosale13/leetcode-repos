import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int HashLen = 256;
        int[] hash = new int[HashLen];
        Arrays.fill(hash, -1);
        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            if (hash[s.charAt(r)] >= l) { 
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(r)] = r;  
            r++;
        }
         return maxLen;
    }
}

