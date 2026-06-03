class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        
    for(int i=0;i<nums.length;i++){
        int count=0;
        for(int j=i+1;j<n;j++){
            if (nums[i]==nums[j])
            count++;
        }
        int k=n/2;
        if(count>=k)
        return nums[i];
    }
        return -1;
    }
}