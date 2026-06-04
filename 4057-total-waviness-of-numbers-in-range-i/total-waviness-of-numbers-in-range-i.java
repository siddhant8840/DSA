class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            int[] d = new int[10];
            int len = 0, x = num;

            while (x > 0) {
                d[len++] = x % 10;
                x /= 10;
            }

            for (int i = 1; i < len - 1; i++) {
                int left = d[i + 1];
                int cur = d[i];
                int right = d[i - 1];

                if ((cur > left && cur > right) ||
                    (cur < left && cur < right))
                    ans++;
            }
        }

        return ans;
    }
}