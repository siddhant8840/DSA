import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        // Step 1: Group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        // Step 2: Process each group
        for (List<Integer> list : map.values()) {
            int k = list.size();
            
            // Prefix sum array
            long[] prefix = new long[k];
            prefix[0] = list.get(0);
            
            for (int i = 1; i < k; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }
            
            for (int i = 0; i < k; i++) {
                long left = 0, right = 0;
                int index = list.get(i);
                
                // Left contribution
                if (i > 0) {
                    left = (long) index * i - prefix[i - 1];
                }
                
                // Right contribution
                if (i < k - 1) {
                    right = (prefix[k - 1] - prefix[i]) 
                          - (long) index * (k - i - 1);
                }
                
                ans[index] = left + right;
            }
        }
        
        return ans;
    }
}