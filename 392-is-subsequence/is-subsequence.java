class Solution {
    public boolean isSubsequence(String s, String t) {
       // int i=0;
    //    int j=0;
    //if (s.length()t.length()) return false;
       int c=0;
        int k=s.length();
        for (int i =0;i<t.length()&&s.length()>c;i++){
            if(s.charAt(c)==t.charAt(i)) {
                c++;
               // j++;
            }
        }
        
        if (c==k) return true;
        return false;
        
    }
}