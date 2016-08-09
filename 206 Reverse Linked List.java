/*
反转单链表，也算是很经典的问题了。
*/

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode p=head,q=null;
        while (head.next!=null){
            p=head;
            head=head.next;
            p.next=q;
            q=p;
        }
        head.next=q;
        return head;
    }
}