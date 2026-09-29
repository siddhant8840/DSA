class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            int max = -1, val = 0;
            Object[] keys = map.keySet().toArray();
            for(int j = 0; j < keys.length; j++) {
                int x = (int)keys[j];
                if(map.get(x) > max) {
                    max = map.get(x);
                    val = x;
                }
            }
            ans[i] = val;
            map.remove(val);
        }

        return ans;
    }
}