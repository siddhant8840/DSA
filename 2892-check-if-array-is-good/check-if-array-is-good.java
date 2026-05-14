class Solution {
    public boolean isGood(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }

        // The array must have length n + 1
        if (nums.length != n + 1) {
            return false;
        }

        int[] count = new int[n + 1];
        for (int num : nums) {
            if (num > n) return false;
            count[num]++;
        }

        // Numbers 1 to n-1 must appear exactly once
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) return false;
        }

        // Number n must appear exactly twice
        return count[n] == 2;
    }
}
