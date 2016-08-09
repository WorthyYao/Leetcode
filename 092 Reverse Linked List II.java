/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

Subscribe to see which companies asked this question

反转m到n之间的链表，还是要创建一个新的头节点会比较好。
*/

public class Solution {
    public ListNode reverseBetween(ListNode head,int m,int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode q=head;
        head=dummy;
        for(int i=0;i<n-m;i++){
            q=q.next;
        }
        for(int i=1;i<m;i++){
            q=q.next;
            head=head.next;
        }
        ListNode pre=head;
        ListNode p=head.next;
        while (p!=q){
            ListNode temp=p.next;
            p.next=q.next;
            q.next=p;
            p=temp;

        }
        head.next=q;
        return dummy.next;
    }
}