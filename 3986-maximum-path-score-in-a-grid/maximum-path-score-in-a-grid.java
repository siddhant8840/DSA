import java.util.*;

class Solution {
    private int[][] grid;
    private Integer[][][] memo;
    private final int INF = 1_000_000_000;

    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        // memo[row][col][remaining_k]
        memo = new Integer[m][n][k + 1];
        
        int result = dfs(m - 1, n - 1, k);
        return result < 0 ? -1 : result;
    }

    private int dfs(int i, int j, int k) {
        // Out of bounds or budget exceeded
        if (i < 0 || j < 0 || k < 0) {
            return -INF;
        }
        
        // Base Case: Starting Point
        if (i == 0 && j == 0) {
            return 0; // Starting grid[0][0] is always 0
        }

        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }

        int score = grid[i][j];
        int cost = (grid[i][j] > 0) ? 1 : 0;

        // Recursively find the max score from Up or Left
        int up = dfs(i - 1, j, k - cost);
        int left = dfs(i, j - 1, k - cost);

        int bestPrev = Math.max(up, left);
        
        // If no valid previous path exists, mark as unreachable
        if (bestPrev <= -INF) {
            return memo[i][j][k] = -INF;
        }

        return memo[i][j][k] = score + bestPrev;
    }
}
