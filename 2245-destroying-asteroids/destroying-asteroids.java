import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Sort the asteroids in ascending order
        Arrays.sort(asteroids);
        
        // Use a long variable to prevent integer overflow when accumulating mass
        long currentMass = mass;
        
        for (int asteroid : asteroids) {
            // If the current planet mass is less than the asteroid, the planet is destroyed
            if (currentMass < asteroid) {
                return false;
            }
            // Otherwise, destroy the asteroid and absorb its mass
            currentMass += asteroid;
        }
        
        return true;
    }
}
