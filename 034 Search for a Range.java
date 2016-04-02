// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].


// 题目的意思是给一个有序数组和一个target，然后返回出现这个target的位置，从出现这个数的位置到最后一次出现这个数
// 这道题目有个比较特殊的需求，就是必须要用时间复杂度o(logn)的算法来算，所以用前后夹逼就不可以
// 所以要用到比较经典的二分法来做。


package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        System.out.println(1);
        int[] ret=new int[2];
        ret[0]=ret[1]=-1;
        int left=0,right=nums.length-1,mid;
        while(left<=right){
            if(nums[left]==target&&nums[right]==target){
                ret[0]=left;
                ret[1]=right;
                break;
            }

            mid=(left+right)/2;

            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else {
                if(nums[right]==target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        System.out.println(1);
        return ret;
    }
}

