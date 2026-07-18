class Solution {
    public boolean isSubsequence(String s, String t) {
        int a=t.length();
        int b=s.length();

        if(a<b){
            return false;
        }
       int i=0;
       int j=0;
       while(i<b && j<a){
        if(s.charAt(i)==t.charAt(j)){
            i++;
        }
        // if(i<s.length())break;
        j++;
       }
       if(i==b){
        return true;
       } 
       return false;
    }
}