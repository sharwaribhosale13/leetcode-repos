class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String a = f(s,i,i), b = f(s,i,i+1);
            if (a.length() > ans.length()) ans = a;
            if (b.length() > ans.length()) ans = b;
        }
        return ans;
    }

    String f(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return s.substring(l+1,r);
    }
}