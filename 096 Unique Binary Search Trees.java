/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

   要求给出二叉搜索数的个数。一道典型的动态规划问题，主要是在于每个节点的数目是等于他的左子数个数以及右子数的乘积的。
*/

public class Solution {
    public int numTrees(int n) {
       int[] res=new int[n+1];
        res[0]=1;res[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=0;j<i;j++){
                res[i]=res[i]+res[j]*res[i-j-1];
            }
        }
        return res[n]; 
    }
}