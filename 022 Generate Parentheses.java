// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"


// 题目的内容为通过给出一个数字n，然后需要返回所有的能够配对的括号组合出来。这道题的正确解法是需要通过dfs深度优先遍历来做
// 现在接触的遍历还很少，这道题目做起来花了很多的时间。最后的答案是参考网上的题解来做的。


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        List<String> inner = new ArrayList<String>(); 
        List<String> outter = new ArrayList<String>(); 
        if (n == 0) {  
            ret.add("");  
            return ret;  
        }  
        if (n == 1) {  
            ret.add("()");  
            return ret;  
        }  
        for (int i = 0; i < n; ++i) {  
            inner = generateParenthesis(i);  
            outter = generateParenthesis(n - i - 1);  
            for (int j = 0; j < inner.size(); ++j) {  
                for (int k = 0; k < outter.size(); ++k) {  
                    ret.add("(" + inner.get(j) + ")" + outter.get(k));  
                }  
            }  
        }  
        return ret;  
    }
}