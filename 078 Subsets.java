/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

这道题目是要求所给的数组的所有集合。已经做了很多道的深度优先搜索的问题了。慢慢的有点儿印象了。把握好剪枝的操作。在这道题目里面是没有剪枝操作的。不过很多题目是有的。
然后还要把握好循环的条件。
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        ArrayList<Integer> item=new ArrayList<Integer>();
        dfs(res,item,nums,0);

        return res;
    }

    private void dfs(List<List<Integer>> res,ArrayList<Integer> item,int [] nums,int start){
        ArrayList<Integer> temp=new ArrayList<Integer>(item);
        res.add(temp);

        for (int i=start;i<nums.length;i++){
            item.add(nums[i]);
            dfs(res,item,nums,i+1);
            item.remove(item.size()-1);
        }
    }
}