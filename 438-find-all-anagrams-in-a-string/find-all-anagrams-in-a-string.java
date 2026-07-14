class Solution {
    public List<Integer> findAnagrams(String s, String p) {


        ArrayList<Integer> list =new ArrayList<>();
        char ps[]=p.toCharArray();
        Arrays.sort(ps);
        for (int i =0;i<=s.length()-p.length();i++){
            String ss =s.substring(i,i+p.length());
            char sa[]=ss.toCharArray();

            Arrays.sort(sa);
            if(Arrays.equals(sa,ps)) list.add(i);

        
          

            
        }
        return list;
        
        
    }
}