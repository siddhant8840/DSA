class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;
    int m, n;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    // Start DFS from unvisited cell
                    if (hasCycle(grid, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasCycle(char[][] grid, int r, int c, int pr, int pc, char val) {
        visited[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            // Check bounds and if neighbor has same value
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == val) {
                if (visited[nr][nc]) {
                    // If visited and not parent, cycle detected
                    if (nr != pr || nc != pc) return true;
                } else {
                    if (hasCycle(grid, nr, nc, r, c, val)) return true;
                }
            }
        }
        return false;
    }
}
