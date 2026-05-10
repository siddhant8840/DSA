import java.util.Arrays;

class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        // dp[i] stores the max jumps to reach index i.
        // Initialize with -1 (unreachable).
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        // Base case: 0 jumps to start at index 0.
        dp[0] = 0;
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // Check if jump condition is met and if start index i is reachable.
                if (Math.abs(nums[j] - nums[i]) <= target) {
                    if (dp[i] != -1) {
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                }
            }
        }
        
        return dp[n - 1];
    }
}
