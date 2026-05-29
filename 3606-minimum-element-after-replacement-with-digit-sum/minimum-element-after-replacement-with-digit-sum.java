class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            int sum = 0;
            for (; n > 0; n /= 10)
                sum += n % 10;
            if (sum < min) {
                min = sum;
                if (min == 1) return 1;
            }
        }

        return min;
    }
}