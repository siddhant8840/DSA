class Solution {
    public int largestAltitude(int[] gain) {
        int max =Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<gain.length;i++){
            sum+=gain[i];
            max=Integer.max(max,sum);

        }
        if(max<0)
        return 0;
        return max;
     
        
    }
}