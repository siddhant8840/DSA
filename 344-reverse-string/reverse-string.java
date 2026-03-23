class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int t=s.length-1;
       // char temp;


        while (i < t) {
            char temp = s[i];
            s[i] = s[t];
            s[t] = temp;
            
            i++;
            t--;
        }
    }
}