class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int c=0 ;
       // boolean s=true;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                 c++;
                 max=Math.max(c,max);


            }
           
            else if (nums[i]==0){
            c=0;
           // continue;
            }

        }

      return max;

        
    }
}