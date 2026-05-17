class Solution {
    public boolean canReach(int[] arr, int start) {
        // Boundary check and cycle prevention
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        
        // Target reached
        if (arr[start] == 0) {
            return true;
        }
        
        // Mark as visited by making the value negative
        arr[start] = -arr[start];
        
        // Explore jump forward (i + arr[i]) and jump backward (i - arr[i])
        // Use Math.abs because we negated the value to mark it visited
        boolean result = canReach(arr, start + Math.abs(arr[start])) || 
                         canReach(arr, start - Math.abs(arr[start]));
        
        // Optional: Reset value if you need to keep the original array intact
        // arr[start] = Math.abs(arr[start]);
        
        return result;
    }
}
