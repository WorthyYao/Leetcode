// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.
/**
 *
 *
 * 
 *这是一道比较简单的链表题，要求是删除倒数第n个节点并返回 头节点。不过我在这道题上面卡了不少时间。
 *
 *主要是因为对边界时间的出错考虑能力不足。
 *在容易出错的边界上面不好判断
 *
 * 我首先想到的是一种比较笨一点也是比较直接的想法。先统计出链表长度，这需要遍历一遍，然后再判断删除哪一个
 *
 * 后来自己做的这种方法是在网上看到的，比我这个花的时间会更少
 *
 * 思路是定义两个节点p，q指向头节点。首先让q移动n个位置从而到达离p有n的距离，再让两个节点同时移动，
 * 当q到达最后时，这个时候p也达到了倒数第n个节点的位置了，这个时候再进行删除节点
 *
 *
 * 
 */

package leetcode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){
            return null;
        }

        ListNode p=head;
        ListNode q=head;

        for(int i=0;i<n;i++){
            q=q.next;
        }
        //后面有一次提交卡在这里，就是没有判断边界条件
        if(q==null){
            return head.next;
        }
        while (q.next!=null){
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;

        return head;
    }
}
