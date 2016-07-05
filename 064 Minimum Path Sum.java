/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

这道题目是求在一个矩阵中的最短路径问题。和前面两道题目是非常像的，也是一个动态规划的问题。

这道题目的精髓是抽象出来sum[i][j]=grid[i][j]+min(sum[i-1][j],sum[i][j-1]),也就是说当前的最小值是需要根据当前值和上方最小值与左方最小值来共同决定。

*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] sum=new int[m][n];
        sum[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            sum[i][0]=sum[i-1][0]+grid[i][0];
        }

        for(int i=1;i<n;i++){
            sum[0][i]=sum[0][i-1]+grid[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                sum[i][j]=grid[i][j]+Math.min(sum[i-1][j],sum[i][j-1]);
            }
        }
        return sum[m-1][n-1];
    }
}