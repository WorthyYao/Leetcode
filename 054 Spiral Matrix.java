// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

//这道题目是求螺旋矩阵


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret=new ArrayList<Integer>();
        int x1=0;
        int y1=0;
        int x2=matrix.length-1;
        if(x2<0) return ret; 
        int y2=matrix[0].length-1;
        while (x1<=x2&&y1<=y2){
            for(int i=y1;i<=y2;i++){
                ret.add(matrix[x1][i]);
            }
            for(int j=x1+1;j<=x2;j++){
                ret.add(matrix[j][y2]);
            }
            if(x1!=x2){
                for(int i=y2-1;i>=y1;i--){
                    ret.add(matrix[x2][i]);
                }
            }
            if(y1!=y2){
                for(int j=x2-1;j>x1;j--){
                    ret.add(matrix[j][y1]);
                }
            }
            x1++;y1++;x2--;y2--;
        }
        return ret;
    }
}
