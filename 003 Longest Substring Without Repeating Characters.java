/*
 * Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
//该解法的时间复杂度为o（n），只遍历了一遍而做到的。思想为判断当前字串中是否含有下一个字符，
//如果没有则j++；而有的话则判断i是否有变化
package leetcode;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		int maxLen=0;
		int i=0;
		int j=0;
		int n=s.length();
		while(j<n){
			String curStr=s.substring(i, j);
			String curChar=s.charAt(j)+"";
			if(curStr.contains(curChar)){
				//判断当前字符串中是否含有当前字符
				maxLen=Math.max(maxLen, j-i);
				if(s.charAt(i)!=s.charAt(j)){
					//本段代码的功能是找出下一个不重复的起点的i。同时j也要加一
					i++;
				}else{
					i++;
					j++;
				}
			}else{
				j++;
			}
		}
		maxLen=Math.max(maxLen, n-i);
		System.out.println(maxLen);
        return maxLen;
    }
	
	public static void main(String[] args) {
		String demo="abcabcbb";
		lengthOfLongestSubstring(demo);
		//System.out.println(Math.max(3, 3));
	}
}
