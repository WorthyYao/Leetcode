/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

和第33题是同一个意思，不同的条件是可以有重复元素。

*/

public class Solution {
    public boolean search(int[] nums, int target) {
        boolean result=false;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==target){
                return true;
            }
        }
        return result;
    }
}