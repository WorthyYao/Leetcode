/**
 *020 Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 *The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 *
 *
 * 要求判断是否配对，熟悉了栈的操作。
 *
 * 
 */



package leetcode;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {

        //初始化一个栈，并且判断是否配对
        Stack<Integer> stk=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            int pos="()[]{}".indexOf(s.substring(i,i+1));
            if(pos%2==1){
                if(stk.isEmpty()||stk.pop()!=pos-1){
                    return false;
                }
            }else {
                stk.push(pos);
            }
        }

        return stk.isEmpty();
    }
}
