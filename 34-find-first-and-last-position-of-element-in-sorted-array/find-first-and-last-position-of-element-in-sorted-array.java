class Solution {
    public int[] searchRange(int[] nums, int t) {
        int a=-1;
        int b=-1;
        int l=0;
        int n=nums.length;
        int r=n-1;
        while(r>=l){
            int m=l+(r-l)/2;
            if(nums[m]==t){
                a=m;
                r=m-1;

            }
            else if (nums[m]>t) r=m-1;
            else if (nums[m]<t)l=m+1; 

        }
         l=0;
         n=nums.length;
         r=n-1;
        while(r>=l){
            int m=l+(r-l)/2;
            if(nums[m]==t){
                b=m;
                l=m+1;

            }
            else if (nums[m]>t) r=m-1;
            else if (nums[m]<t)l=m+1; 

        }


        return new int []{a,b};
        
    }
}