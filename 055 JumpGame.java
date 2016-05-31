055 Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


这道题的要求是判断最后在给定的数组中能否走到最后的一个问题，解决思路是每走一步的时候判断是否越过界。
时间复杂度为o(n).


public class Solution {
    public boolean canJump(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if (max==0) return false;
            max--;
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return true;
    }
}