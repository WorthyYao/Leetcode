/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

又是一道翻转链表的问题，本来觉得没什么。还是取p，q两个指针，先让q走一段路。接着两个一起走就可以了。
结果给出了一组数据我的内心是崩溃的。k的数值比链表的长度还要长，原来还要判断一下k的值大小。只好先遍历一遍
链表，先得出链表的长度n，然后再用k取余。即k=k%n.
*/

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null||head.next==null) return head;
        ListNode p=head;ListNode q=head;ListNode len=head;
        int n=0;
        while (len!=null){
            n++;
            len=len.next;
        }
        k=k%n;
        if(k==0||k==n) return head;
        for(int i=0;i<k;i++){
            q=q.next;
        }
        while (q.next!=null){
            p=p.next;
            q=q.next;
        }
        ListNode temp=p.next;
        p.next=null;
        q.next=head;
        return temp;
    }
}
