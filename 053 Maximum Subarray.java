// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.


// 最大子列和问题，以前曾经在网易云课堂的数据结构中学过。

// 穷举法思路简单，时间复杂度为o(n2)，分治法为o(nlogN)。


public class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			max=Math.max(max,sum);
			sum=Math.max(sum,0);
		}
		return max;  
    }
}