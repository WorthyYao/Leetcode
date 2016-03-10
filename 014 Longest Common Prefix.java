/**
 * 014 Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 *这道题要求求出一组字符串数组中最长的前缀字符串
 *思路是按照第一个字符串进行遍历，并且找出最长的相同字符串出来，并且返回
 *
 */
package leetcode;

public class Solution {

    public String longestCommanPrefix(String[] strs){
        if(strs.length==0)
            return "";
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<strs.length;j++){
                //判断当前字符串长度是否小于第一个字符串长度，或者第i个字符处不相等
                if(strs[j].length()<=i||strs[j].charAt(i)!=strs[0].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}
