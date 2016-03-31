// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


// 这道题卡了我好长时间啊。用栈来匹配，如果有一对的就返回长度，否则进行另外的处理

package leetcode;

public class oj {
	public int longestValidParentheses(String s) {
		if (null == s || 0 == s.length()) {
            return 0;
        }
		int max=0;
		int start=0;
		int count=0;
		int[] stack=new int[s.length()];
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				stack[count]=i;
				count++;
			}else{
				count--;
				if(count==0){
					max=Math.max(max, i-start+1);
				}else if(count<0){
					start=i;
					count=0;
				}else{
					max=Math.max(max, i-stack[count-1]);
				}
			}
		}
		
		
        return max;
    } 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="()()()()";
		oj o=new oj();
		o.longestValidParentheses(s);
		
	}

}
