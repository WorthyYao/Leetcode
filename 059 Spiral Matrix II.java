/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
螺旋矩阵第二道。不过并没有太大的新意。和第一道的思路基本是差不多的。就像剥洋葱，一层层的剥下去就可以了。

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int x1=0, y1=0;
        int x2=n-1, y2=n-1;
        int temp=0;
        while (x1<=x2&&y1<=y2){
            for(int i=y1;i<=y2;i++){
                temp++;
                matrix[x1][i]=temp;
            }
            for(int i=x1+1;i<=x2;i++){
                temp++;
                matrix[i][y2]=temp;
            }
            if(x1!=x2){
                for(int i=y2-1;i>=y1;i--){
                    temp++;
                    matrix[x2][i]=temp;
                }
            }
            if(y1!=y2){
                for(int i=x2-1;i>x1;i--){
                    temp++;
                    matrix[i][y1]=temp;
                }
            }
            x1++;y1++;x2--;y2--;
        }
        return matrix;
    }
}
