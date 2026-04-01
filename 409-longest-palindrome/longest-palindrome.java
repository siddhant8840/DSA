class Solution {
    public int longestPalindrome(String s) {
        HashMap < Character,Integer > lp =new HashMap<>();
        int length=0;
        boolean odd=false;
        for (int i=0;i<s.length();i++){
            char c =s.charAt(i);
           // String key =String
           lp.put(c,lp.getOrDefault(c,0)+1);
          // boolean odd=false;
        }
           for (int count:lp.values()){
            if (count%2==0)
            length=length+count;
            else {
            length =length+(count-1);
            odd=true;}
           }
        
            if (odd==true)
            length+=1;
        
        
       return length;
    }
}