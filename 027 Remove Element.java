// Given an array and a value, remove all instances of that value in place and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

// Example:
// Given input array nums = [3,2,2,3], val = 3

// Your function should return length = 2, with the first two elements of nums being 2.


//这一题和前面那道题目是类似的，改动的地方是删除一个指定的元素，将前面那道题目稍加修改即可




package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0)
            return 0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[cnt]=nums[i];
                ++cnt;
            }
        }
        return cnt;
    }
}