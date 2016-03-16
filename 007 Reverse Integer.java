/*
007 Reverse Integer
转换数值
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */

package leetcode;

public class Solution {
	public static int reverse(int x) {
		//本题的难点在于如何处理数据的越界问题，当x大于或者小于整型数的最大最小值的时候，需要return出来
		if(x==0||x<=Integer.MIN_VALUE||x>=Integer.MAX_VALUE ) return 0;
		//定义一个flag标志，当x成为负数的时候，将他先处理成正数，并赋个标记位，等到结束的时候转成负数
		int flag=1;
		int a=0,b=0;
		long  ret=0;//长整型的目的在于能够判断是否数值是否越界
		if(x<0){
			flag=-1;
		}
		x=Math.abs(x);  //将x取正
		while(x!=0){
			a=x%10;
			x=x/10;
			//判断是否溢出
			if(ret*10+a>Integer.MAX_VALUE) return 0;
			ret=ret*10+a;
		}
		
		ret=ret*flag;
		x=(int)ret;
        return x;
    }
	
	public static void main(String[] args) {
		int x=-5;
		reverse(x);
	}
}
