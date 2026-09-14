class Solution {
    public String longestCommonPrefix(String[] s) {
        String p=s[0];
        for(int i=1;i<s.length;i++)
            while(!s[i].startsWith(p))
                p=p.substring(0,p.length()-1);
        return p;
    }
}