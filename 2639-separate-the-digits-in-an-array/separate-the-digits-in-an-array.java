class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        
        for (int num : nums) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                // Character.getNumericValue converts '1' to 1
                resultList.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        
        // Convert the List back to the required int[] array
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}
