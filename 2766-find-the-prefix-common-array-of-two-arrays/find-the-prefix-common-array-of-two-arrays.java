class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] count = new int[n + 1]; // Elements are from 1 to n
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Increment count for current element in A
            // If it becomes 2, it's common
            if (++count[A[i]] == 2) {
                commonCount++;
            }
            
            // Increment count for current element in B
            // If it becomes 2, it's common
            if (++count[B[i]] == 2) {
                commonCount++;
            }
            
            // Store the running total of common elements
            ans[i] = commonCount;
        }
        
        return ans;
    }
}
