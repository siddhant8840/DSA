class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # Create a DP table filled with False
        # Rows = string s + 1, Columns = pattern p + 1
        dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
        
        # Empty string and empty pattern is always a match
        dp[0][0] = True
        
        # Handle patterns with '*' at the start (e.g., "a*b*")
        for j in range(2, len(p) + 1):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 2]
                
        for i in range(1, len(s) + 1):
            for j in range(1, len(p) + 1):
                # If the characters match or pattern has a '.'
                if p[j - 1] == s[i - 1] or p[j - 1] == '.':
                    dp[i][j] = dp[i - 1][j - 1]
                # If the pattern has a '*'
                elif p[j - 1] == '*':
                    # Option 1: Ignore the '*' and the character before it (match zero times)
                    dp[i][j] = dp[i][j - 2]
                    # Option 2: If the character before '*' matches the current string char, 
                    # we can use the '*' to match one or more times
                    if p[j - 2] == s[i - 1] or p[j - 2] == '.':
                        dp[i][j] = dp[i][j] or dp[i - 1][j]
                        
        return dp[len(s)][len(p)]
