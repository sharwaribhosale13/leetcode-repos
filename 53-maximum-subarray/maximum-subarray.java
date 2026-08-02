class Solution {
    public int maxSubArray(int[] a) {
        int sum=0, max=a[0];
        for(int x:a){ sum=Math.max(x,sum+x); max=Math.max(max,sum); }
        return max;
    }
}