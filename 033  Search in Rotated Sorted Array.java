// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

//这道题的题目本身我不是太清楚，直接找出所需要的target所在位置不就可以了= =。


public class Solution {
    public int search(int[] nums, int target) {
        int index=-1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                index=i;
                break;
            }
        }
        return index;
    }
}