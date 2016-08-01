/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

这道题目的意思是需要在一个逆序的数组中，找出给出的目标数的位置来。
如果是普通查找的话，遍历一次数组就可以了。非常的简单，但是o(n)的时间复杂度就不行了。
典型的要用二分搜索来做。由于这道题目相较于普通的二分搜索来说的话，因为逆序了，所以要多一个判断。
好在在每次二分的时候，都只有一边是逆序的，而另一边则是有序的，所以加一个判断就好了。思路是比较清晰的。
*/
public class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid;
        while (left<=right){
            mid=(left+right)/2;
            if (target==nums[mid]) return mid;
            if (nums[mid]<nums[right]){
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }else {
                if(target<nums[mid]&&target>=nums[left]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}