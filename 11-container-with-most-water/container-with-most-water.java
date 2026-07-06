class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers at opposite ends of the array
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        // Move pointers toward each other until they meet
        while (left < right) {
            // Width is the distance between the two lines
            int width = right - left;
            
            // Height is limited by the shorter of the two lines
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate current water capacity
            int currentArea = width * currentHeight;
            
            // Track the maximum capacity seen so far
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
