class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Return the first (and smallest) common element
            } else if (nums1[i] < nums2[j]) {
                i++; // Move the pointer for nums1 forward
            } else {
                j++; // Move the pointer for nums2 forward
            }
        }
        
        return -1; // Return -1 if no common element is found
    }
}
