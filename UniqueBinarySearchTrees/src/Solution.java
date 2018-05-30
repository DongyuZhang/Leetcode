public class Solution {
    public static void main(String[] args){}

    /***
     * #96
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n
     * @param n
     * @return unique BST number
     * Denote that G(n) is the number of unique BST for value 1 ... n
     * F(i, n) is the number of unique BST for value 1 ... n with the root as i
     * G(n) = Sum(F(i, n)) 1<=i<=n
     * F(i, n) = G(i-1)*G(n-i)
     * The point is that the number of unique BST for value 1...3 is the same as that for 5...7
     * G(n) = Sum(G(i-1)*G(n-i))
     * G(0) = 1; G(1) = 1;
     */
    public static int numTrees(int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
