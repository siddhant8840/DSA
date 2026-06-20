class Solution {
    public boolean isValid(String s) {
        Deque<Character> st =new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
         if (x=='('||x=='['||x=='{')
         st.push(x);
         else{
         if (st.isEmpty()==true) return false;
         char top=st.pop();
          if(x==')'&& top!='('||x=='}'&& top!='{'||x==']'&& top!='[')
         return false;
         }
         

        }
        return st.isEmpty();


        
    }
}