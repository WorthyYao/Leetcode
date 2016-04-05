// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0


// 这道题目要求往数组中插入一个target，觉得这道题应该算是不难的，不知道为何会放到medinum难度中来。我最开始做的就是最简单的循环一次数组而已，
// 提交也通过了。因为这道题没有对时间复杂度提出要求，循环一次复杂度是o（N）。后面去网上看别人写的，基本都是用二分法，时间复杂度为o（logN），
// 也就改用了一下。比较坑的是怎么判断返回的边界，这个每次都不太好判断，有不少坑。


package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
}
