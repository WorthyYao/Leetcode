/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

典型的动态规划，也是斐波那契数列问题。前面做过好几道动态规划的问题了，这道算还好了。
*/
public class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}