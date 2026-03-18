class Solution {
    public boolean isPalindrome(String s) {
         s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
         int l=s.length()-1;
         int r=0;
          while(r<l)
          {
            if (s.charAt(l)!=s.charAt(r))
            return false;
                l--;
                r++;

          }
return true;
    }
}