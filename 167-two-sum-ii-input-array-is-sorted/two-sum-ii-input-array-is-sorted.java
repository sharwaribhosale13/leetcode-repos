class Solution {
    public int[] twoSum(int[] num, int tar) {
        int left=0;
        int right=num.length-1;

        while(left<right)
        {
            if(num[left]+num[right] >tar)
            {
                right=right-1;
            }
            else if(num[left]+num[right] < tar)
            {

                left=left+1;            
            }
            else
            {
                return new int[]{left+1,right+1};
            }
        }
        return null;
        
    }
}
