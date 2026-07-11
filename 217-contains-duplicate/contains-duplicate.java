class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
            map.put(nums[i],map.get(nums[i])+1);
            else 
            map.put(nums[i],1);
        }
       // System.out.println(map);
       ArrayList<Integer> key =new ArrayList<>(map.keySet());
       for (int i=0;i<key.size();i++){
        if (map.get(key.get(i))>1)
        return true ;
       }
       return false;
    }
}