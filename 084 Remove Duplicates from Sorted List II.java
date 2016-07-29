/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

和83题基本一致，不过有一个不同的地方是需要将所有重复的元素全部删除，而不能保留一个元素。
当遇到链表的时候，经常需要考虑到用到生成一个前趋节点来解决问题。
*/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null){
            while (cur.next!=null&&pre.next.val==cur.next.val){
                cur=cur.next;
            }
            if (pre.next==cur){
                pre=pre.next;
            }else {
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}