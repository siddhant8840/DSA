class Solution {
    public boolean canConstruct(String r, String m) {
       // return magazine.contains(ransomNote);
       int []cou=new int[26];
       for(char c: m.toCharArray())
       cou[c-'a']++;
       for(char c: r.toCharArray()){
       cou [c-'a']--;
       if(cou[c-'a']<0) return false;

       }
       return true;
    }
}