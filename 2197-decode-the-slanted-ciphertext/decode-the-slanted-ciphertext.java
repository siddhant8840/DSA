class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();

        // Each original character sequence starts from the first row
        for (int j = 0; j < cols; j++) {
            int r = 0;
            int c = j;
            // Move diagonally: (0, j) -> (1, j+1) -> (2, j+2) ...
            while (r < rows && c < cols) {
                sb.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }

        // Remove trailing spaces as per problem constraints
        int lastIdx = sb.length() - 1;
        while (lastIdx >= 0 && sb.charAt(lastIdx) == ' ') {
            lastIdx--;
        }
        
        return sb.substring(0, lastIdx + 1);
    }
}
