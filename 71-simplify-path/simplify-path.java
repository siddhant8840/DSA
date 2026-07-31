class Solution {
    public String simplifyPath(String path) {
       String [] p= path.split("/");
       int n =p.length;
       Stack<String> st=new Stack<>();
       for(int i=0;i<n;i++){
        if(p[i].equals(".")||p[i].equals("")) continue;
        else if (p[i].equals("..")){if (!st.isEmpty())
            st.pop();}
        else st.push(p[i]);

       }
       StringBuilder ans = new StringBuilder();
      
       for(String sss:st){
        ans.append("/");
        ans.append(sss);
       }
        if (ans.length() == 0)
          return "/";
       return ans.toString();
    


      
       //return "s";

    }
}