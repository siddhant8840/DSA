import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        List<Integer> result = new ArrayList<>();
        
        // Sequential numbers can have lengths from 2 to 9 digits
        for (int length = 2; length <= 9; length++) {
            for (int start = 0; start <= 9 - length; start++) {
                // Extract the substring of the current length
                String numStr = sample.substring(start, start + length);
                int num = Integer.parseInt(numStr);
                
                // Add to result if it fits within the boundaries
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}
