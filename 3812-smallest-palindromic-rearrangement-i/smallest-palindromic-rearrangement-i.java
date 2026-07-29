class Solution {
    public String smallestPalindrome(String s) {
        int fr [] =new int[26];
        for(char c:s.toCharArray()){
            fr[c-'a']++;
        }
        StringBuilder st =new StringBuilder();
        String cc="";
        for(int i=0;i<26;i++){
            while(fr[i]>=2){
                st.append((char)('a'+i));
                fr[i]-=2;
                
            }
            if(fr[i]==1) {
                cc= s.valueOf((char)('a'+ i));}

            
        }
              String right = new StringBuilder(st).reverse().toString();
              System.out.println(right);
               System.out.println(cc);
                System.out.println(st);


        return st.toString() + cc + right;


        



      
    }
}