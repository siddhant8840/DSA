import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixSet = new HashSet<>();
        
        // Step 1: Insert all prefixes of numbers in arr1 into the HashSet
        for (int num : arr1) {
            String str = String.valueOf(num);
            String prefix = "";
            for (char ch : str.toCharArray()) {
                prefix += ch;
                prefixSet.add(Integer.parseInt(prefix));
            }
        }
        
        int maxLength = 0;
        
        // Step 2: For each number in arr2, find its longest prefix in the HashSet
        for (int num : arr2) {
            String str = String.valueOf(num);
            String prefix = "";
            for (char ch : str.toCharArray()) {
                prefix += ch;
                int currentPrefix = Integer.parseInt(prefix);
                if (prefixSet.contains(currentPrefix)) {
                    maxLength = Math.max(maxLength, prefix.length());
                } else {
                    // No need to check longer prefixes if the current one isn't matched
                    break; 
                }
            }
        }
        
        return maxLength;
    }
}
