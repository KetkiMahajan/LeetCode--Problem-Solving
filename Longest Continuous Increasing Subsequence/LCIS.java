//Using DP to solve the LCIS
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen=0;
        int len=0;
        
        int[] lcs= new int[nums.length];
        Arrays.fill(lcs,1);
        
        if(nums.length > 0)
        {
            maxLen=lcs[0];
            for(int i=1;i<nums.length;i++)
            {
                if(nums[i]>nums[i-1]){
                    lcs[i]=lcs[i-1]+1;
                    len=lcs[i];
                }
                if(len>maxLen){
                    maxLen=len;
                }
            }
        }
        
     
        return maxLen;
    }
}
