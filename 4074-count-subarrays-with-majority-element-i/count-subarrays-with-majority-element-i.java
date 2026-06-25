class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int totalSubarrays = 0;
        
        // Fenwick tree (Binary Indexed Tree) to count smaller prefix sums efficiently
        // Max possible index size is 2 * n + 2 due to offset
        int[] bit = new int[2 * n + 2];
        
        // Helper function to update Fenwick Tree
        int offset = n + 1; // Shifts values from [-n, n] to [1, 2n+1]
        
        // Initial state: Prefix sum before processing any element is 0
        update(bit, 0 + offset, 1);
        
        int currentPrefixSum = 0;
        
        for (int num : nums) {
            // Step 1: Update running prefix sum based on target matching
            if (num == target) {
                currentPrefixSum += 1;
            } else {
                currentPrefixSum -= 1;
            }
            
            // Step 2: Query how many previous prefix sums are strictly less than currentPrefixSum
            // This is equivalent to finding j where currentPrefixSum - prefixSum[j] > 0
            totalSubarrays += query(bit, currentPrefixSum + offset - 1);
            
            // Step 3: Add the current prefix sum into our tracker
            update(bit, currentPrefixSum + offset, 1);
        }
        
        return totalSubarrays;
    }
    
    private void update(int[] bit, int index, int delta) {
        while (index < bit.length) {
            bit[index] += delta;
            index += index & (-index);
        }
    }
    
    private int query(int[] bit, int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }
}
