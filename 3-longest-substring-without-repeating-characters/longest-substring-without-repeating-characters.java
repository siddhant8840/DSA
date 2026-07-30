class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set =new HashSet<>();
        int n=s.length();
        int l=0;
        int ml=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
               
            }
            set.add(c);
             ml=Math.max(ml,r-l+1);
            
            
        }
        return ml;


    }
}