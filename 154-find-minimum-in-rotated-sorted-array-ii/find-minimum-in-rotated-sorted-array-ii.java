class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum must be in the right half
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                // Minimum could be mid, so check the left half including mid
                high = mid;
            } else {
                // When nums[mid] == nums[high], we cannot be sure
                // Reduce the search space by 1
                high--;
            }
        }
        return nums[low];
    }
}
