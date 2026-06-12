import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private int[] depth;
    private int[][] up;
    private int maxLog;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        maxLog = (int) (Math.log(n) / Math.log(2)) + 2;

        // 1. Build adjacency list correctly
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        depth = new int[n + 1];
        up = new int[n + 1][maxLog];

        // 2. Precompute Powers of 2 to avoid manual exponentiation per query
        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // 3. Standard BFS for Node Depth and Binary Lifting Table (Root = 1)
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        depth[1] = 0;
        up[1][0] = 1;

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    depth[v] = depth[u] + 1;
                    up[v][0] = u;
                    for (int j = 1; j < maxLog; j++) {
                        up[v][j] = up[up[v][j - 1]][j - 1];
                    }
                    queue.offer(v);
                }
            }
        }

        // 4. Answer Queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0; // Cost is 0 (which is even), so 0 ways to make it odd
                continue;
            }

            int lca = getLCA(u, v);
            int dist = depth[u] + depth[v] - 2 * depth[lca];

            // Combinatorics property: ways to assign weights for an odd total sum is 2^(dist - 1)
            ans[i] = pow2[dist - 1];
        }

        return ans;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];
        for (int j = 0; j < maxLog; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = maxLog - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}
