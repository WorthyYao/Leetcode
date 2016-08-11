/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

二叉树的中序遍历。数据结构中二叉树已经学过很多次了，但是这还是第一次用代码来实现他。递归的办法还是很有意思的。


  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
*/

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }

    public void inorder(TreeNode node,List<Integer> res){
        if(node==null) return;
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }
}