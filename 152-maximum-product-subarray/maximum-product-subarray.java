class Solution {
    public int maxProduct(int[] nums) {
     
        int n=nums.length;
        int maximum_sum=nums[0];

        for(int i=0;i<n;i++)
        {
            int p=1;
            for(int j=i;j<n;j++)
            {
                p*= nums[j];
                maximum_sum=Math.max(maximum_sum,p);

            }
        } 
       return maximum_sum; 
    }
}