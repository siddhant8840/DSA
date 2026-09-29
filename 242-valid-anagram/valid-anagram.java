class Solution {
    public boolean isAnagram(String s, String t) {
         int fre[] =new int [26];
         if(s.length()!=t.length())return false;
         for(int i=0;i<s.length();i++){
             char c=s.charAt(i);
             char d=t.charAt(i);
             fre[c-'a']++;
             fre[d-'a']--;
         } 
         for(int i=0;i<26;i++){
            if(fre[i]!=0)return false;
         }
         return true;

        
    }
}