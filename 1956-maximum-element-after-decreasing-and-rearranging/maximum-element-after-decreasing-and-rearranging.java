import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Sort the array to process elements sequentially
        Arrays.sort(arr);
        
        // The first element must strictly be 1
        arr[0] = 1;
        
        // Iterate through the array to ensure the absolute difference is at most 1
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        
        // The last element in the sorted array will be the maximum
        return arr[arr.length - 1];
    }
}
