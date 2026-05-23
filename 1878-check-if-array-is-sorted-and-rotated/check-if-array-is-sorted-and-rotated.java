class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Compare current element with the next element (modulo n for wrap-around)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        
        // A valid sorted and rotated array can have at most 1 drop
        return count <= 1;
    }
}
