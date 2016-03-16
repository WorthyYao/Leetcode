/*
009 Palindrome Number
Determine whether an integer is a palindrome. Do this without extra space.
这题刚开始看了没有思路，一看网上大神的题解。写的好简单啊= =。太弱了。传一个数进来后，判断是否是回文字符串的
办法是反转这个字符串，并判断这个反转后的字符串是否与原字符串相等，如果相等就是回文的。
 */

package leetcode;

public class Solution {
	public static boolean isPalindrome(int x) {
		long xx=x;
		long new_xx=0;
		while (xx>0){
			new_xx=new_xx*10+xx%10;
			xx=xx/10;
		}
		
		//System.out.println(x);
		return new_xx==x;
    }
	
	public static void main(String[] args) {
		int x=5;
		isPalindrome(x);
	}
}
