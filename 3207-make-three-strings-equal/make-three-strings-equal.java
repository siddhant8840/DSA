class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int p = s3.length();
        int c = 0;
        int mini = Math.min(n, Math.min(m, p));
        for (int i = 0; i < mini; i++) {
            if (s1.charAt(i) == s2.charAt(i) &&
                s2.charAt(i) == s3.charAt(i)) {
                c++;
            } else {
                break;
            }
        }
        if (c == 0)
            return -1;
        else
            return (n - c) + (m - c) + (p - c);
    }
}