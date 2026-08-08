class Solution {
    public int maxArea(int[] h) {
        int max=0;
        int l=0;
        int r=h.length-1;
        while(r>l){
            int he=r-l;
            int wid=Math.min(h[l],h[r]);
            max=Math.max(max,wid *he);
            if(h[l]>h[r])r--;
            else l++;

        }return max;
        
    }
}