class Solution {
    public int[] sortedSquares(int[] nums) {
       int  rs[]=new int[nums.length];
       int l=0;
       int r =nums.length-1;
       for(int i =nums.length-1;i>=0;i--){
        int lsum=nums[l]*nums[l];
        int rsum=nums[r]*nums[r];
        if(lsum>rsum){
            rs[i]=lsum;
            l++;
        }
        if(lsum<=rsum){
            rs[i]=rsum;
            r--;
        }

       }
       return rs;

    }
}