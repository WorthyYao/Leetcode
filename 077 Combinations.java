/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


被这道题坑了超级长的时间。题目很长时间内都没有看明白。我把中间的诸如[2,4]以为是从2到4.我就觉得很奇怪，明明是挑出k个数，为什么挑出这么多数字来。就因为这个卡了好久的时间。
这道题目又是一道深度优先搜索的问题，也就是回溯法的应用。说起来这种题目已经做了好几道了。慢慢的有点儿感觉，但还是需要多练习练习。
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(n<=0||n<k) return res;
        ArrayList<Integer> item=new ArrayList<>();
        dfs(n,k,1,item,res);
        return res;

    }

    private void dfs(int n,int k,int start,ArrayList<Integer> item,List<List<Integer>> res){
        if(item.size()==k){
            ArrayList<Integer> temp=new ArrayList<Integer>(item);
            res.add(temp);
            return;
        }

        for (int i=start;i<=n;i++){
            item.add(i);
            dfs(n,k,i+1,item,res);
            item.remove(item.size()-1);
        }
    }
}