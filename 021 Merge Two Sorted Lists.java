// 021 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
/**
 *  将两个链表合并，要求不能返回的链表不能有新生成的链表。
 *  思路是通过设立一个头节点，然后将两个链表比较大小插进去，当有一个链表全部插入完成时，就将另外一个链表全部链接过去
 *  算法复杂度为o(m+n)
 */

package leetcode;

import java.util.Stack;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root=new ListNode(0);
        ListNode cur=root;
        //l1或者l2是空的，直接返回另外一个
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1==null){
            cur.next=l2;
        }else {
            cur.next=l1;
        }
        return root.next;
    }
}