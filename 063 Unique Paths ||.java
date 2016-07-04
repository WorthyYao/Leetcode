/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
这道题目和前面的62是同一样的题目，所以就放在一起来写了。题目的意思是要找出机器人在一个m*n的矩阵中到达对角的所有可能。
而63和62所不同的是，题目中设置了障碍，当遇到障碍的时候，这条路就是走不通的情况。
题目的解决方法是用动态规划来解决的。如果能注意到，其中每个点的总路数其实是它的上面那个点的路数与左边路数之和。
问题是好解决的。而在本道题目中，在遇到障碍的时候，将那一个具体格置为0即可。
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]path=new int[m][n];

        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                path[i][0]=1;
            }else{
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]!=1){
                path[0][i]=1;
            }else{
                break;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    path[i][j]=0;
                }else {
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
        }

        return path[m-1][n-1];
    }
}