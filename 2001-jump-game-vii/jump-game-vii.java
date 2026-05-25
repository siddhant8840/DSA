import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        int farthest = 0; // Tracks the furthest index checked to prevent redundant calculations

        while (!queue.isEmpty()) {
            int i = queue.poll();
            
            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, s.length() - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    if (j == s.length() - 1) return true;
                    queue.offer(j);
                }
            }
            farthest = i + maxJump;
        }
        return false;
    }
}
