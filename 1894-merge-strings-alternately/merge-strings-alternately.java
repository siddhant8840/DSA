class Solution {
    public String mergeAlternately(String w1, String w2) {
        int l1=w1.length();
        int l2=w2.length();
        int lm=Math.max(l1,l2);
        StringBuilder sb =new StringBuilder();
        //sb.append("h");
        for(int i=0;i<lm;i++) {
            if (i<l1) sb.append(w1.charAt(i));
             if (i<l2) sb.append(w2.charAt(i));

           
           
        }

        return sb.toString();
        
        
    }
}