// 028 Implement strStr()

// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


//这道题目的要求是查找一个字符串中有没有另外一个字符串，如果没有的话，就返回-1,有的话则返回第一次出现的位置就可以了


//突然想起来，这道题好像就是来iotlab第一次老师让我做的题目，当时不会做，一个字都写不下去。现在想想好简单。。。。。这是到目前为止leetcode做的最简单的一道题目


public class Solution {
    public int strStr(String haystack, String needle) {
        
        //一次循环，判断当前开始是否是相同的
        for(int i=0;i<=haystack.length()-needle.length();i++){
          //如果两个字符串相同的情况下，则返回位置，否则返回-1
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}