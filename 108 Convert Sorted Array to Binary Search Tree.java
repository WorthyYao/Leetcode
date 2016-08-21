/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
要求将给出的一个数组转换为一个二叉搜索树。可以想到的问题是，在给出一个数组的时候，以他的中点为根这样递归下去其实就是一个二叉搜索树。

*/

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int left,int right){
        if (left>right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
}