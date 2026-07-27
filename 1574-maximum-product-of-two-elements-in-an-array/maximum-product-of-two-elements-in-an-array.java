class Solution {
    public int maxProduct(int[] nums) {

        int biggest = 0;
        int secondBiggest = 0;

        for (int value : nums) {

            if (value >= biggest) {
                secondBiggest = biggest;
                biggest = value;
            } else if (value > secondBiggest) {
                secondBiggest = value;
            }
        }

        return (biggest - 1) * (secondBiggest - 1);
    }
}