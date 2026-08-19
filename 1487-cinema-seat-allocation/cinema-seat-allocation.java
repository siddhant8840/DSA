import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] r : reservedSeats) {
            if (r[1] >= 2 && r[1] <= 9) {
                map.put(r[0], map.getOrDefault(r[0], 0) | (1 << (r[1] - 2)));
            }
        }
        int ans = (n - map.size()) * 2;
        for (int mask : map.values()) {
            boolean left = (mask & 15) == 0;
            boolean right = (mask & 240) == 0;
            if (left && right) ans += 2;
            else if (left || right || (mask & 60) == 0) ans += 1;
        }
        return ans;
    }
}
