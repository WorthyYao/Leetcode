/*
    Follow up for N-Queens problem.
    Now, instead outputting board configurations, return the total number of distinct solutions.
    还是八皇后的问题，只不过要求的是总的数目，代码没有改，只是在返回的时候，直接将res改成了返回list的size().
*/


public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res=new ArrayList<List<String>>();
        dfs(n,0,new int[n],res);
        return res.size();
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