import java.util.*;

class Solution {
    private static class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int size) {
            this.n = size;
            this.tree = new int[4 * size];
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l || l > r) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            int p1 = query(2 * node, start, mid, l, r);
            int p2 = query(2 * node + 1, mid + 1, end, l, r);
            return Math.max(p1, p2);
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        // Dynamically define the boundary maximum based on constraints
        int maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        
        TreeSet<Integer> obstacles = new TreeSet<>();
        SegmentTree segTree = new SegmentTree(maxCoord + 2);
        
        // Boundaries tracking
        obstacles.add(0);
        obstacles.add(maxCoord + 1);
        segTree.update(1, 0, maxCoord + 1, 0, maxCoord + 1);

        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            if (type == 1) {
                Integer prev = obstacles.lower(x);
                Integer next = obstacles.higher(x);

                obstacles.add(x);

                // Split the segment: update lengths at the lower boundaries
                segTree.update(1, 0, maxCoord + 1, prev, x - prev);
                segTree.update(1, 0, maxCoord + 1, x, next - x);
            } else {
                int sz = q[2];
                
                // Find largest obstacle position strictly less than or equal to x
                Integer prev = obstacles.floor(x);
                int limit = (prev == null) ? 0 : prev;

                // 1. Get the largest completely bound gap to the left of the 'limit' obstacle
                int maxGap = segTree.query(1, 0, maxCoord + 1, 0, limit - 1);
                
                // 2. Safely check the active tail gap stretching from 'limit' up to x
                int tailGap = x - limit;
                
                // The true maximum capacity is the best of both segments
                int totalMaxGap = Math.max(maxGap, tailGap);

                results.add(totalMaxGap >= sz);
            }
        }
        return results;
    }
}
