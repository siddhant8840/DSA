
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        if( s.length()!=t.length())
        return false;
        HashMap<Character,Character> m =new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char c1=s.charAt(i);
             char c2=t.charAt(i);
             if (m.containsKey(c1))
             {
                if (m.get(c1)!=c2)
                return false;
             }
             else 
             m.put(c1,c2);
            
        }
             return true;
        //i have to try again this code 
        //41/47 passed 

    }
}
