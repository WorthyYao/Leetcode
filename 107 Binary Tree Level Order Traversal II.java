/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
还是中序遍历，有一个不同的地方是在于要求逆序的将排序输出，在得出结果后，再次进行一次逆转就可以了。
*/

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return null;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp=new LinkedList<Integer>();
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode head=queue.poll();
                temp.add(head.val);
                if (head.left!=null) queue.offer(head.left);
                if (head.right!=null) queue.offer(head.right);
            }
            res.add(temp);
        }
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for (int i=res.size()-1;i>=0;i--){
            result.add(res.get(i));
        }
        return result;
    }
}