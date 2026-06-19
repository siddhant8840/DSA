class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int ca=0;
        for(int i=0;i<nums.length;i++){
            if(c==0)
            ca=nums[i];
            if(nums[i]==ca)
            c++;
            else
            c--;
        }
        return ca;
    }
}