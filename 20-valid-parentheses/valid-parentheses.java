class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put('(',')');
          map.put('{','}');
            map.put('[',']');
        Stack<Character> st =new Stack<>();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(map.containsKey(c)) st.push(c);
            else{
               if (st.isEmpty()) return false;
               if(map.get(st.pop())!=c) return false;

            }
        }
        return st.isEmpty();
        

        
    }
}