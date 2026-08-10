class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum =0;
        int n =nums.length;
         //no double 
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int mx=sum;
        for(int i=k;i<n;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            mx=Math.max(sum,mx);
        }
        return(double)mx/k;

    




        
    }
}