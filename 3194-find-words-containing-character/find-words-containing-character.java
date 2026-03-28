class Solution {
    public List<Integer> findWordsContaining(String[] words, char x){
        List<Integer> re  =new ArrayList<>();
        //traversing through string 
        int len=words.length;
        //outer word length 
        for (int i=0;i<len;i++)
        {
            String each=words[i];
            int len2=each.length();
            //inner word length 
            for(int j=0;j<len2;j++){
                if (each.charAt(j)==x){
                    re.add(i);
                    break;
                }
            }
            
            
        }
        return re;
        
        
    
    
    }
}