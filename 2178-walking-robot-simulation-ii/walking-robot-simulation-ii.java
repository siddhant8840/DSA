class Robot {
    private int width;
    private int height;
    private int pos;
    private int perimeter;
    private boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        // The total number of unique cells on the perimeter
        this.perimeter = 2 * (width + height - 2);
        this.pos = 0;
        this.moved = false;
    }

    public void step(int num) {
        this.moved = true;
        // Modulo arithmetic handles any number of laps around the grid
        this.pos = (this.pos + num) % this.perimeter;
    }

    public int[] getPos() {
        // Map the linear 'pos' back to XY coordinates
        if (pos < width) {
            return new int[]{pos, 0};
        } else if (pos < width + height - 1) {
            return new int[]{width - 1, pos - (width - 1)};
        } else if (pos < 2 * width + height - 2) {
            return new int[]{width - 1 - (pos - (width + height - 2)), height - 1};
        } else {
            return new int[]{0, height - 1 - (pos - (2 * width + height - 3))};
        }
    }

    public String getDir() {
        // Critical edge case: if at (0,0) after moving, direction is "South"
        if (pos == 0 && moved) {
            return "South";
        }
        
        // Determine direction based on which side of the rectangle the robot is on
        if (pos >= 1 && pos < width) {
            return "East";
        } else if (pos >= width && pos < width + height - 1) {
            return "North";
        } else if (pos >= width + height - 1 && pos < 2 * width + height - 2) {
            return "West";
        } else {
            // Initial state (pos=0, !moved) is "East", 
            // but the very last segment of the loop is "South"
            return (pos == 0 && !moved) ? "East" : "South";
        }
    }
}
