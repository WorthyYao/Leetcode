/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

这道题目要求的是树的层序遍历。这道题花了挺长的时间。
在做树的层序遍历的时候，要引入出队列来做。主要的思想是，当遍历一层的时候，将这一层的元素都要放入队列中，而在遍历他们的时候，则将他们都删除掉。
今天做的时候才发现在java里面队列是用了Linkedlist类实现的。其中用到了几个平时并不太常用的方法。其中包括队列的offer方法，以及判断是否为空的方法。还有将元素拿出来并从
队列中删除掉的poll方法。
*/

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp=new ArrayList<Integer>();
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode head=queue.poll();
                temp.add(head.val);
                if (head.left!=null) queue.offer(head.left);
                if (head.right!=null) queue.offer(head.right);
            }
            res.add(temp);
        }
        return res;
    }
}