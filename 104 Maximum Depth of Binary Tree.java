/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

题目的要是是给出一个二叉树的深度。其实说白了就是求一个二叉树的最大层数，还是用层序遍历来做一下，做的时候统计一下深度就可以了。这道题目算是比较简单的一道题目。

*/

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            res=res+1;
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode head=queue.poll();
                if (head.left!=null) queue.offer(head.left);
                if (head.right!=null) queue.offer(head.right);
            }
        }
        return res;
    }
}