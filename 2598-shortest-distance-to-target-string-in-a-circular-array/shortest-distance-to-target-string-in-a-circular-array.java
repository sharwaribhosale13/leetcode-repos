class Solution {
    public int closestTarget(String[] words, String target, int startind) {
        int n=words.length;
       int result = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            if(words[i].equals(target))
            {
                int straightdist=Math.abs(i-startind);
                int circulardist=n-straightdist;

                result=Math.min(result,Math.min(straightdist,circulardist));
            }
        }
        return result==Integer.MAX_VALUE ?-1:result;

        
    }
}