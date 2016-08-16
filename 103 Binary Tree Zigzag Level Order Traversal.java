/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

要求之子型存储数据。不过是和前面的层序遍历还是差不多的。区别在于，正常的普通层序遍历需要引入队列的帮助。
而在用到这个的时候，因为有的时候是需要判断是否是需要从后往前的。所以需要一个index来判断从前走还是从后走。
所以需要用到栈来操作。
*/

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (root==null) return res;
        boolean index=true;
        Stack<TreeNode> currStack=new Stack<TreeNode>();
        currStack.push(root);
        while (!currStack.isEmpty()){
            List<Integer> currRes=new ArrayList<Integer>();
            Stack<TreeNode> nextStack=new Stack<TreeNode>();
            while (!currStack.isEmpty()){
                TreeNode head=currStack.pop();
                currRes.add(head.val);
                if (index){
                    if (head.left!=null) nextStack.push(head.left);
                    if (head.right!=null) nextStack.push(head.right);
                }else {
                    if (head.right!=null) nextStack.push(head.right);
                    if (head.left!=null) nextStack.push(head.left);
                }
            }
            currStack=nextStack;
            res.add(currRes);
            index=!index;
        }
        return res;
    }
}