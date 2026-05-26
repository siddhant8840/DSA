class Solution {
    public int numberOfSpecialChars(String word) {
        // Frequency track arrays for 26 English alphabets
        boolean[] lowerCaseSeen = new boolean[26];
        boolean[] upperCaseSeen = new boolean[26];
        int specialCount = 0;
        
        // Loop through the word and track seen characters via ASCII manipulation
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                lowerCaseSeen[ch - 'a'] = true; // Map 'a'-'z' to index 0-25
            } else if (ch >= 'A' && ch <= 'Z') {
                upperCaseSeen[ch - 'A'] = true; // Map 'A'-'Z' to index 0-25
            }
        }
        
        // Count how many alphabet positions have both casing variants marked true
        for (int i = 0; i < 26; i++) {
            if (lowerCaseSeen[i] && upperCaseSeen[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}
