// Reverse Nodes in k-Group

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

//这到题目的要求是将一个给定的链表每k个元素进行一次逆转。最后是用递归来做的。还刚开始接触递归，做起来很不顺手。


package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        int n=0;
        while (cur!=null&&n!=k){
            cur=cur.next;
            n++;
        }
        if(n==k) {
            reverseKGroup(cur, n);

            while (--n >= 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;

    }
}
