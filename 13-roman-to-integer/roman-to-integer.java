class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int v1 = getVal(s.charAt(i));
            
            if (i < s.length() - 1) {
                int v2 = getVal(s.charAt(i + 1));
                
                if (v1 < v2) {
                    ans -= v1;
                } else {
                    ans += v1;
                }
            } else {
                ans += v1;
            }
        }
        
        return ans;
    }
    
    public int getVal(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        return 1000; // 'M'
    }
}