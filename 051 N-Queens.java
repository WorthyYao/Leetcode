/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

这道题是八皇后问题。今天下午看了一下午，是应用回溯法解决该种问题的经典问题。所谓的回溯法，是需要运用深度优先搜索的策略来进行操作的。

今天下午看了一下午。每一次遇到递归的问题都要想很长时间，总是觉得太抽象了，不容易理解。

*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<List<String>>();
        dfs(n,0,new int[n],res);
        return res;
    }

    private void dfs(int n,int row,int[] temp,List<List<String>> res){
        if(row==n){
            List<String> item=new LinkedList<>();
            for (int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if (temp[i]==j){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                item.add(sb.toString());
            }
            res.add(item);
            return;
        }


        for (int i=0;i<n;i++){
            temp[row]=i;
            if(check(row,temp)){
                dfs(n,row+1,temp,res);
            }
        }
    }

    private boolean check(int row,int[] temp){
        for (int i=0;i<row;i++){
            if(temp[row]==temp[i]||Math.abs(temp[row]-temp[i])==row-i){
                return false;
            }
        }
        return true;
    }
}