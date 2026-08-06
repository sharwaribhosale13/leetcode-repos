class Solution {
    public String reverseWords(String s) {
        String[] a=s.trim().split("\\s+");
        String r="";
        for(int i=a.length-1;i>=0;i--) r+=a[i]+" ";
        return r.trim();
    }
}