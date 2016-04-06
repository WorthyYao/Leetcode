// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.



// 题目要求是判断一个数独是否是一个有效的数独，从八点四十开始做。十点一十提交成功，花了不少时间。题目的难度是easy，我主要是卡在两个地方花了一点时间去弄懂。

// 第一个，因为是要分别判断一行，一列，一块的元素是否有重复。前面的行和列好理解，后面怎么循环一个块花了不少时间去理解。在一个三阶矩阵分别是k/3和k%3，循环。

// 另外是判断一个数字是否有着重复。用了一个boolean数组，初始化全为false，当遇到重复的就直接退出return出false了。只有当所有元素全部遍历都可以时才return true出来

// 另外还了解了在java中，char字符是可以进行简单的加减运算的。


package leetcode;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean[] map=new boolean[9];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(map[(int)(board[i][j]-'1')]){
                        return false;
                    }else{
                        map[(int)(board[i][j]-'1')]=true;
                    }
                }
            }
        }

        for(int j=0;j<9;j++){
            boolean[] map=new boolean[9];
            for(int i=0;i<9;i++){
                if(board[i][j]!='.'){
                    if(map[(int)(board[i][j]-'1')]){
                        return false;
                    }else{
                        map[(int)(board[i][j]-'1')]=true;
                    }
                }
            }
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                boolean[] map=new boolean[9];
                for(int k=0;k<9;k++){
                    if(board[i+k/3][j+k%3]!='.'){
                        if(map[(int)(board[i+k/3][j+k%3]-'1')]){
                            return false;
                        }else{
                            map[(int)(board[i+k/3][j+k%3]-'1')]=true;
                        }
                    }
                }
            }
        }

        return true;
    }
}

