/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

题目的意思是给出一个字符串，求出这个字符串的最后一个没有空格的完整的字符串。
题目的难度还好，我想到的是从字符串的最后开始出发，先找到end在哪里。
然后再找出start在哪里。最后返回两个的之差就可以了。我在做的时候，遇到的一个坑就是
在判断end的时候，是判断的s.length!=' '，给搞反了。
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==0) return 0;
        int end=s.length()-1;
        while (end>=0&&s.charAt(end)!=' '){
            end--;
        }
        if(end==-1) return 0;
        int start=end;
        while (start>=0&&s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }
}
