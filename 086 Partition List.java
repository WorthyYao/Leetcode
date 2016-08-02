/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

题目的要是是在给定一个链表和一个指定元素的情况下，根据这个元素来翻转。
生成两个链表，比给定元素小的放在左边，大的放在右边，在遍历结束之后将其连接在一起就可以了。
*/

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null) return head;
        ListNode leftDummpy=new ListNode(0);
        ListNode rightDummpy=new ListNode(0);
        ListNode left=leftDummpy,right=rightDummpy;
        while (head!=null){
            if(head.val<x){
                left.next=head;
                left=head;
            }else {
                right.next=head;
                right=head;
            }
            head=head.next;
        }
        right.next=null;
        left.next=rightDummpy.next;
        return leftDummpy.next;
    }
}
