class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
          int sum = 0;
          int num = nums[i];
          while(num > 0 ){
            int digit = num%10;
            sum += digit;
            num/= 10;
          }
          nums[i] = sum;
        }
        int min = nums[0];
        for(int i = 1 ; i < n ; i++){
   
           if(nums[i] < min){
             min = nums[i];
           }
        }
        return min;
    }
}