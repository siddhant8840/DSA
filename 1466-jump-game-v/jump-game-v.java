import java.util.Arrays;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        // Initialize the cache with -1 to indicate uncalculated indices
        Arrays.fill(dp, -1);
        
        int maxVisited = 0;
        // Try starting from every single index to find the absolute maximum
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, d, i, dp));
        }
        
        return maxVisited;
    }
    
    private int dfs(int[] arr, int d, int i, int[] dp) {
        // If we have already calculated the max jumps from index i, return it
        if (dp[i] != -1) {
            return dp[i];
        }
        
        int currentMax = 1; // You can always at least visit the starting index itself
        int n = arr.length;
        
        // 1. Look towards the right directions (i + x)
        for (int x = 1; x <= d && i + x < n; x++) {
            // CRITICAL: We cannot jump over an index that is higher or equal to arr[i]
            if (arr[i + x] >= arr[i]) {
                break; 
            }
            currentMax = Math.max(currentMax, 1 + dfs(arr, d, i + x, dp));
        }
        
        // 2. Look towards the left directions (i - x)
        for (int x = 1; x <= d && i - x >= 0; x++) {
            // CRITICAL: We cannot jump over an index that is higher or equal to arr[i]
            if (arr[i - x] >= arr[i]) {
                break;
            }
            currentMax = Math.max(currentMax, 1 + dfs(arr, d, i - x, dp));
        }
        
        // Cache the computed result
        dp[i] = currentMax;
        return currentMax;
    }
}