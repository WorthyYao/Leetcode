/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
这道题目和78题是一样的，唯一不同的地方是数组中可以出现重复的元素。
用java解决的话，比较好的方式就是调用一下hashset就可以了。
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> item=new ArrayList<>();
        dfs(res,item,0,nums);
        HashSet<List<Integer>> set=new HashSet<List<Integer>>(res);
        res.clear();
        res.addAll(set);

        return res;
    }

    public void dfs(List<List<Integer>> res,List<Integer> item,int start,int[] nums ){
        ArrayList<Integer> temp=new ArrayList<Integer>(item);
        res.add(temp);
        for (int i=start;i<nums.length;i++){
            item.add(nums[i]);
            dfs(res,item,i+1,nums);
            item.remove(item.size()-1);
        }
    }
}