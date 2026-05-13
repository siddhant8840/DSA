class Solution {
    public int minMoves(int[] nums, int limit) {
        // Difference array to track moves for each possible sum S from 2 to 2*limit
        int[] delta = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            // Range [2, 2 * limit] initially requires 2 moves
            delta[2] += 2;
            delta[2 * limit + 1] -= 2;

            // Range [min(a, b) + 1, max(a, b) + limit] requires only 1 move
            // So we reduce the move count by 1 in this range
            int minVal = Math.min(a, b);
            int maxVal = Math.max(a, b);
            delta[minVal + 1] -= 1;
            delta[maxVal + limit + 1] += 1;

            // The specific sum (a + b) requires 0 moves
            // We already reduced it to 1 move above, so reduce by 1 more
            delta[a + b] -= 1;
            delta[a + b + 1] += 1;
        }

        int minMoves = n;
        int currentMoves = 0;
        // Iterate through the difference array to find the minimum sum
        for (int i = 2; i <= 2 * limit; i++) {
            currentMoves += delta[i];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
