/**
 *4Sum
 *Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * 
 * The solution set must not contain duplicate quadruplets.
 *
 * 这题花了比较长的时间，首先是准备用hashmap来解决，后来发现功力不够= =，
 * 搞了很长时间都没有弄出来，最后改用三重循环来做出来的。最后调边界的时候也花了很长的时间
 */
package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //初始化一个List集合
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        int len=nums.length;
        //先将数组进行排序，从而通过夹逼来搞定
        Arrays.sort(nums);
        //对数组进行循环
        for(int m=0;m<=len-4;m++){
            for(int n=m+1;n<=len-3;n++){
                int i=n+1;
                int j=len-1;

                while (i<j){
                    //判断当前四个数字和是否等于target。
                    int sum=nums[m]+nums[n]+nums[i]+nums[j];
                    //如果小于target则让i++
                    if(sum<target){
                        ++i;
                    }else if(sum>target){
                        --j;
                    }else {
                        //当四个数字和等同于target时，则将该四个数字加入到ret中
                        ret.add(Arrays.asList(nums[m],nums[n],nums[i],nums[j]));
                        ++i;
                        --j;
                        while (i<j&&nums[i]==nums[i-1]){
                            ++i;
                        }
                        while (i<j&&nums[j]==nums[j+1]){
                            --j;
                        }
                    }
                    while (n<=len-4&&nums[n]==nums[n+1]){
                        ++n;
                    }
                }
                while (n<=len-4&&nums[n]==nums[n+1]){
                    ++n;
                }
            }
            while (m<=len-3&&nums[m]==nums[m+1]){
                ++m;
            }
        }
        return ret;



    }
}
