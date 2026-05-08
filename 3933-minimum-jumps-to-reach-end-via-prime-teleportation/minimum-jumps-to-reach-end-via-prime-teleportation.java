import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        // Step 1: Build Smallest Prime Factor sieve
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int[] spf = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) spf[i] = i;
        for (int i = 2; (long) i * i <= maxVal; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }

        // Step 2: Map each prime factor -> list of indices that have that factor
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            while (val > 1) {
                int p = spf[val];
                primeToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (val % p == 0) val /= p; // remove all occurrences
            }
        }

        // Step 3: BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.offer(0);
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            jumps++;
            while (size-- > 0) {
                int i = queue.poll();

                // Adjacent steps
                for (int next : new int[]{i - 1, i + 1}) {
                    if (next >= 0 && next < n && !visited[next]) {
                        if (next == n - 1) return jumps;
                        visited[next] = true;
                        queue.offer(next);
                    }
                }

                // Prime teleportation: only if nums[i] is itself prime
                int val = nums[i];
                if (val > 1 && spf[val] == val) { // nums[i] is prime
                    List<Integer> targets = primeToIndices.remove(val); // consume & delete
                    if (targets != null) {
                        for (int j : targets) {
                            if (!visited[j]) {
                                if (j == n - 1) return jumps;
                                visited[j] = true;
                                queue.offer(j);
                            }
                        }
                    }
                }
            }
        }

        return -1; // unreachable (shouldn't happen per constraints)
    }
}