class Solution {
    public void moveZeroes(int[] nums) {
       int c=0;
        int j=0;
        int n =nums.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0)
           c++;
            else{
            arr[j]=nums[i];
            j++;
            }
        }
        for(;j<n;j++){
            arr[j]=0;
        }
         for (int i = 0; i < n; i++)
            nums[i] = arr[i];

        
        
    }
}