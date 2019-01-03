class Solution {
/*

Denote dp[i] denotes that if s[0...i-1] can be segmented from wordDict
dp[0] = true
dp[i] = dp[j] && wordDict.contains(s[j...i-1]), 0<=j<i
what we want is dp[s.length()]
*/
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<String>(wordDict);
        if(hs.contains(s))
          return true;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
          for(int j = 0; j < i; j++){
            if(dp[j] && hs.contains(s.substring(j, i))){
              dp[i] = true;
              break;
            }
          }
        }
        return dp[s.length()];
    }
}
