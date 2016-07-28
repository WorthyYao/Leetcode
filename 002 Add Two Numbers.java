/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

package leetcode;

public class Solution {
	 public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){ 
			this.val = x; 
			next=null;
		}
	 }
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode ret = new ListNode(0);  
        ListNode cur = ret;  
  
        int sum = 0;  
        while (true) {  
            if (l1 != null) {  
                sum += l1.val;  
                l1 = l1.next;  
            }  
            if (l2 != null) {  
                sum += l2.val;  
                l2 = l2.next;  
            }  
            cur.val = sum % 10;  
            sum /= 10;  
            if (l1 != null || l2 != null || sum != 0) {  
                cur = (cur.next = new ListNode(0));  
            } else {  
                break;  
            }  
        }  
        return ret;  
	}
	
	public static void main(String[] args) {
		//节点的初始化
		ListNode l1=new ListNode(2);
		ListNode b=new ListNode(4);
		ListNode c=new ListNode(3);
		ListNode d=new ListNode(9);
		ListNode l2=new ListNode(5);
		ListNode e=new ListNode(6);
		ListNode f=new ListNode(4);
		System.out.println(9/10);
		//将节点串联起来
		l1.next=b;
		b.next=c;
		c.next=d;
		l2.next=e;
		e.next=f;
		addTwoNumbers(l1, l2);
		//System.out.println("hl");
		
	}
}
