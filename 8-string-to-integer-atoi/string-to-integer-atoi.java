class Solution {
    public int myAtoi(String s) {
        s=s.trim(); int i=0,sg=1; long n=0;
        if(i<s.length()&&(s.charAt(i)=='-'||s.charAt(i)=='+')) sg=s.charAt(i++)=='-'?-1:1;
        while(i<s.length()&&Character.isDigit(s.charAt(i))){
            n=n*10+s.charAt(i++)-'0';
            if(n*sg>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(n*sg<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        }
        return (int)(n*sg);
    }
}