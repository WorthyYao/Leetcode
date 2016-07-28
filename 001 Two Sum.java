/*001 two sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Subscribe to see which companies asked this question
 * */

package leetcode;

public class Solution {
	public  int[]  twoSum(int []nums,int target){
		int []index=new int[2];
		int sum=0;
		/*
		通过循环遍历后，将吻合题目要求的两个数值找出来，并得到他们的位置，
		将他们的数值加一后存入数组中，即得到了正确的数值
		*/
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				sum=nums[i]+nums[j];
				if(sum==target){
						index[0]=i+1;
						index[1]=j+1;
					System.out.println(index[0]);
					System.out.println(index[1]);
					return index;
				}
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={2,7,11,15,45};
		int target=60;
		Solution sol=new Solution();
		sol.twoSum(arr,target);
	}
}
