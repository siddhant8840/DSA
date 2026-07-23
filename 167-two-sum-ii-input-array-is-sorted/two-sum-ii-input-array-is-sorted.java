class Solution {
    public int[] twoSum(int[] nu, int t) {
        int le=0;
        int ri=nu.length-1;
        while(ri>le){
            int sum=nu[le]+nu[ri];
            if (sum==t) return new int []{le+1,ri+1};
            else if(sum>t) ri--;
            else le++;

        }

        return new int[]{};
    }
}