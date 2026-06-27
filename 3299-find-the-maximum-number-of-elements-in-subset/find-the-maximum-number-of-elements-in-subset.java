import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxNum = 0;
        
        // Count frequencies and find the maximum element in the array
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }

        int ans = 1; // Minimum possible subset size

        // Handle the edge case for number '1'
        if (count.containsKey(1)) {
            int ones = count.get(1);
            if (ones % 2 == 0) {
                ans = ones - 1; // Needs to be an odd subset size
            } else {
                ans = ones;
            }
        }

        // Test every number as the starting point of the sequence
        for (int num : nums) {
            if (num <= 1) continue;

            int length = 0;
            long x = num;

            // Follow the increasing order of the pattern: x, x^2, x^4, ...
            while (x <= maxNum && count.containsKey((int) x) && count.get((int) x) >= 2) {
                length += 2;
                x *= x;
            }

            // After the loop, determine if we can add the peak or if we stepped too far
            if (x <= maxNum && count.containsKey((int) x)) {
                ans = Math.max(ans, length + 1);
            } else {
                ans = Math.max(ans, length - 1);
            }
        }

        return ans;
    }
}
