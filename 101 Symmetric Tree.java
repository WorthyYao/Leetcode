/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

判断一个二叉树是否是镜面对称的二叉树。这道题目也是一个树的遍历问题。不过由于是需要判断是否是镜面对称的问题。等于是p的左子树与q的右子树之间进行判断。
*/

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    
    public boolean isSymmetric(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        return isSymmetric(p.left,q.right)&&isSymmetric(p.right,q.left);
    }
}