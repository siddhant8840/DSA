class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        java.util.Arrays.fill(lower, -1);
        java.util.Arrays.fill(upper, -1);

        // Store indices of each character
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = i; 
            } else {
                int idx = c - 'A';
                if (upper[idx] == -1) {
                    upper[idx] = i; // Store only the first occurrence of uppercase
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            // Check if both exist and if lowercase comes before the first uppercase
            if (lower[i] != -1 && upper[i] != -1 && lower[i] < upper[i]) {
                count++;
            }
        }
        return count;
    }
}
