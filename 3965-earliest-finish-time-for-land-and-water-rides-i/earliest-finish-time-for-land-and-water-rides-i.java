class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;

        // Try all combinations of land ride i and water ride j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Sequence 1: Land Ride -> Water Ride
                int finish1 = Math.max(landStartTime[i], 0) + landDuration[i];
                finish1 = Math.max(waterStartTime[j], finish1) + waterDuration[j];
                
                // Sequence 2: Water Ride -> Land Ride
                int finish2 = Math.max(waterStartTime[j], 0) + waterDuration[j];
                finish2 = Math.max(landStartTime[i], finish2) + landDuration[i];

                // Keep the minimum of both plans and all possible combinations
                minFinishTime = Math.min(minFinishTime, Math.min(finish1, finish2));
            }
        }
        return minFinishTime;
    }
}
