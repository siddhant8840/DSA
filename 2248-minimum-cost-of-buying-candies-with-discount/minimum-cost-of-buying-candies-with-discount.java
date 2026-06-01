import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        // Sort the array in ascending order
        Arrays.sort(cost);
        
        int totalCost = 0;
        int n = cost.length;
        
        // Traverse backwards to pick the most expensive candies first
        for (int i = n - 1; i >= 0; i--) {
            // If the index is (n - 3), (n - 6), etc., it is the 3rd candy (free)
            // Skip the free candy
            if ((n - i) % 3 == 0) {
                continue;
            }
            totalCost += cost[i];
        }
        
        return totalCost;
    }
}
