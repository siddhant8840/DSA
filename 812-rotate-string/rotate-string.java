class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are different, goal cannot be a rotation of s
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself. If goal is a rotation of s, 
        // it must be a substring of s + s.
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
