// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

//要求给出一个链表，将链表的每两个节点互换。通过引入一个新的头节点，指向head，然后两两互换，最后返回头节点。
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre=new ListNode(0);
        ListNode cur=head;
        pre.next=head;
        ListNode h=pre;
        while(cur!=null&&cur.next!=null){
            pre.next=cur.next;
            cur.next=cur.next.next;
            pre.next.next=cur;

            pre=cur;
            cur=cur.next;
        }

        return h.next;
    }
}
