class Solution{
    public int numberOfSubstrings(String s,int k){
        int[] count=new int[26];
        int left=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            count[s.charAt(right)-'a']++;
            while(count[s.charAt(right)-'a']>=k){
                count[s.charAt(left)-'a']--;
                left++;
            }
            ans+=left;
        }
        return ans;
    }
}