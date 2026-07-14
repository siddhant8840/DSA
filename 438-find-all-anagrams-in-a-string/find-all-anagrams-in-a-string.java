class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(p.length()>s.length())
            return result;
        int[] f1=new int[26];
        int[] f2=new int[26];
        for(int i=0;i<p.length();i++){
            f1[s.charAt(i)-'a']++;
            f2[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(f1,f2))
            result.add(0);
        for(int i=p.length();i<s.length();i++){
            f1[s.charAt(i)-'a']++;
            f1[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(f1,f2))
                result.add(i-p.length()+1);
        }
        return result;
    }
}