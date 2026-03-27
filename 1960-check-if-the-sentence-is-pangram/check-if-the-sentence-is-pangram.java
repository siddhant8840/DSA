class Solution {
    public boolean checkIfPangram(String sentence) {
       // char letter[]=new char[26];
       int count[]=new int [26];
       int n=sentence.length();
       for (int i=0;i<n;i++){
        count[sentence.charAt(i)-'a']++;
       }
       for (int i=0;i<26;i++){
        if (count[i]==0)
        return false;
        
        
       }
       return true;



        
    }
}