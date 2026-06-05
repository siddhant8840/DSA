import java.util.Arrays;

public class Solution {
    // 5D memoization array: [idx][prev][prev2][isLess][isStarted]
    // Since prev and prev2 can be unset, we map the unset state (-1) to index 10.
    private long[][][][][] memoCount;
    private long[][][][][] memoWaviness;

    public long totalWaviness(long num1, long num2) {
        return countWavinessUpTo(num2) - countWavinessUpTo(num1 - 1);
    }

    private long countWavinessUpTo(long n) {
        if (n < 100) {
            return 0;
        }
        
        String s = Long.toString(n);
        int len = s.length();
        
        // Dimensions: len x 11 x 11 x 2 x 2
        memoCount = new long[len][11][11][2][2];
        memoWaviness = new long[len][11][11][2][2];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    Arrays.fill(memoCount[i][j][k][0], -1);
                    Arrays.fill(memoCount[i][j][k][1], -1);
                    Arrays.fill(memoWaviness[i][j][k][0], -1);
                    Arrays.fill(memoWaviness[i][j][k][1], -1);
                }
            }
        }
        
        long[] result = digitDP(0, -1, -1, 0, 0, s);
        return result[1];
    }

    private long[] digitDP(int idx, int prev, int prev2, int isLess, int isStarted, String s) {
        if (idx == s.length()) {
            return new long[]{1, 0}; // Base case: 1 valid number formed, 0 future waviness
        }

        int pIdx = (prev == -1) ? 10 : prev;
        int p2Idx = (prev2 == -1) ? 10 : prev2;

        if (memoCount[idx][pIdx][p2Idx][isLess][isStarted] != -1) {
            return new long[]{
                memoCount[idx][pIdx][p2Idx][isLess][isStarted],
                memoWaviness[idx][pIdx][p2Idx][isLess][isStarted]
            };
        }

        int limit = (isLess == 1) ? 9 : (s.charAt(idx) - '0');
        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limit; d++) {
            int nextLess = (isLess == 1 || d < limit) ? 1 : 0;
            
            if (isStarted == 0) {
                if (d == 0) {
                    // Still tracking leading zeros
                    long[] nextState = digitDP(idx + 1, -1, -1, nextLess, 0, s);
                    totalCount += nextState[0];
                    totalWaviness += nextState[1];
                } else {
                    // Placing the very first non-zero digit
                    long[] nextState = digitDP(idx + 1, d, -1, nextLess, 1, s);
                    totalCount += nextState[0];
                    totalWaviness += nextState[1];
                }
            } else {
                // Number has started; placing intermediate digits
                long[] nextState = digitDP(idx + 1, d, prev, nextLess, 1, s);
                
                // Evaluate if 'prev' qualifies as a peak or a valley
                long addedWaviness = 0;
                if (prev2 != -1) {
                    if ((prev > prev2 && prev > d) || (prev < prev2 && prev < d)) {
                        addedWaviness = 1;
                    }
                }
                
                totalCount += nextState[0];
                totalWaviness += nextState[1] + (addedWaviness * nextState[0]);
            }
        }

        memoCount[idx][pIdx][p2Idx][isLess][isStarted] = totalCount;
        memoWaviness[idx][pIdx][p2Idx][isLess][isStarted] = totalWaviness;

        return new long[]{totalCount, totalWaviness};
    }
}
