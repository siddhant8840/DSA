class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            String s = String.valueOf(num);

            for (int i = 1; i < s.length() - 1; i++) {
                char left = s.charAt(i - 1);
                char cur = s.charAt(i);
                char right = s.charAt(i + 1);

                if ((cur > left && cur > right) ||
                    (cur < left && cur < right)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}