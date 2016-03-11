/**
* 015 3Sum
*
* Given an array S of n integers, 
*are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
*
*Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
*The solution set must not contain duplicate triplets.
*   For example, given array S = {-1 0 1 2 -1 -4},
*
*   A solution set is:
*  (-1, 0, 1)
* (-1, -1, 2)
* 
*这道题的要求是在给定的一个数组中找出三个和为0的数字，并返回所有组合的序列，其中不能包含相同的数据
*
*这道题的思路大概是先将所给的一组数组进行排序，然后再进行接下来的操作。
*
*
*
*
*
*
*/
package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums){
        //定义一个ret序列，将得到的数组集合存到这里面来
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        int len=nums.length,tar=0;
        //长度小于2时会直接返回出去
        if(len<=2)
            return ret;

        Arrays.sort(nums);
        //进行一次循环遍历
        for(int i=0;i<=len-3;i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < tar) {
                    ++j;
                } else if (nums[i] + nums[j] + nums[k] > tar) {
                    --k;
                } else {
                    //当出现符合目标的一组数的时候，将该组数放到ret集合中去
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    //当接下来的数字与之前的相同时。则跳过该数字
                    while (j < k && nums[j] == nums[j - 1])
                        ++j;
                    while (j < k && nums[k] == nums[k + 1])
                        --k;
                }
            }
            while (i <= len - 3 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return ret;
    }
}
