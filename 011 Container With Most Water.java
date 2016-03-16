/*
011 Container With Most Water
Given n non-negative integers a1, a2, ..., an, 
where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 Find two lines, which together with x-axis forms a container, 
 such that the container contains the most water.


该题的意思是找出两个板之间贮水面积最大的板块，找出并返回出来。
一种最直接的解法就是遍历数组每段距离的面积，并找出最大值。但是这样做的话的时间复杂度是o（n^2），超过了
时间的限制。
这样转而想到一种时间复杂度为n的算法，设立两个指针，分别从前后开始遍历，同时判断这一次的面积是否与最大值的大小，
同时，判断左右指针哪边的高度比较小，较小的一方往前挪动，这样的话只需要一次遍历就可以，时间复杂度为n。
非常的好看

Note: You may not slant the container.
 */

package leetcode;

public class Solution {
	public int maxArea(int[] height) {
		//分别定义左右两边的位置，并且开始循环
		int left=0,right=height.length-1;
		int area=0;
		while(left<right){
			area=Math.max(area, Math.min(height[left], height[right])*(right-left));
			if(height[left]>height[right]){
				right--;
			}else{
				left++;
			}
			
		}
		
		return area;
    }
	
	public static void main(String[] args) {
		Solution s=new Solution();
		int height[]={1,2,3,4,5};
		s.maxArea(height);
	}
}
