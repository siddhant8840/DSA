class Solution {
    /**
     * Calculates the furthest distance from the origin by counting 'L', 'R', and '_'.
     * The strategy is to move all flexible moves ('_') in the direction 
     * that is already the furthest from the origin.
     */
    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0;
        int rCount = 0;
        int blankCount = 0;

        // Count occurrences of each character
        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                lCount++;
            } else if (move == 'R') {
                rCount++;
            } else {
                blankCount++;
            }
        }

        // The furthest distance is the difference between fixed moves 
        // plus all flexible moves added to the "winning" side.
        return Math.abs(lCount - rCount) + blankCount;
    }
}