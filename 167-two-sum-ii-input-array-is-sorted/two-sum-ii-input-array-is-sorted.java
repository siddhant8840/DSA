class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int n =nums.length;
        for(int i=0;i<n;i++){
            int c=target-nums[i];
           if( map.containsKey(c)){
            int ans []= new int[2];
            ans[0]=map.get(c)+1;
            ans[1]=i+1;
            return ans ;
           }
           map.put(nums[i],i);
        }
        int k[]=new int [2];
        return k;


        
    }
}