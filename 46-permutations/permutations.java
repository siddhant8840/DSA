import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        // Base case: If we have picked all numbers, we found a valid permutation
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the number is already in the current permutation
            if (tempList.contains(nums[i])) continue; 
            
            // 1. Choose
            tempList.add(nums[i]);
            
            // 2. Explore
            backtrack(list, tempList, nums);
            
            // 3. Un-choose (Backtrack)
            tempList.remove(tempList.size() - 1);
        }
    }
}
