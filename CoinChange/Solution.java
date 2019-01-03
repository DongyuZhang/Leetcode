class Solution {


  /*

    Denote dp[i] -> least amount of coins to make change amount i
    Assume we have c[0..n] kinds of coins. c[i] denotes the denomination of the coin
    dp[0] = 0
    dp[j] = min{dp[j-c[i]]}+1, 0<=i<n,c[i]<=j
    what we want is dp[amount]

    To identify the amount that cannot be reached, we initialize the array with each value
    as amount+1. So when the amount cannot be reached, dp[i] will be bigger than
    amount
  */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
          for(int j = 0; j < coins.length; j++){
            if(coins[j]<=i)
              dp[i] = Math.min(dp[i], dp[i-coins[j]]);
          }
          dp[i]++;
        }
        return dp[amount]>amount? -1 : dp[amount];
    }
}
