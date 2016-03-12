/**
 * 16. 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *   
 * 这道题是昨天刚做的求和问题的类似，不过要比上一道提要简单一点，思路是一样的
 * 先将数组进行排序，然后找出最近的三个数字  
 *   
 */

package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int len=nums.length;
        int sum;
        int ret=nums[0]+nums[1]+nums[2];
        for(int i=0;i<=len-3;i++){
            int j=i+1;
            int k=len-1;
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(ret-target)){
                    ret=sum;
                }
                if(sum<target){
                    ++j;
                }else if(sum>target){
                    --k;
                }else {
                    ++j;
                    --k;
                }
            }
        }
        return ret;
    }
}
