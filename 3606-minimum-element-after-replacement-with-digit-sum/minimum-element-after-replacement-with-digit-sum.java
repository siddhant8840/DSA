class Solution {
    public int minElement(int[] nums) {
        int min = 128;
        for (int n : nums) {
            int s = 0;
            for (; n > 0; n /= 10) s += n % 10;
            if (s < min) min = s;
            if (min == 1) return 1;
        }
        return min;
    }
}