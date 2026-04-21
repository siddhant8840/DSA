import java.util.*;

class Solution {

    int[] parent;

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;
        parent = new int[n];

        // Step 1: Initialize DSU
        for (int i = 0; i < n; i++) parent[i] = i;

        // Step 2: Build groups
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

        // Step 3: Store frequency of source in each group
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            map.putIfAbsent(root, new HashMap<>());

            Map<Integer, Integer> freq = map.get(root);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }

        // Step 4: Match target
        int res = 0;

        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> freq = map.get(root);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                res++;
            }
        }

        return res;
    }
}