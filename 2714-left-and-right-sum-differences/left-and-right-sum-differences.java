class Solution {
    public int[] leftRightDifference(int[] nums) {
        int l = 0, r = 0;

        for (int x : nums) {
            r += x;
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            r -= nums[i];
            ans[i] = Math.abs(l - r);
            l += nums[i];
        }

        return ans;
    }
}