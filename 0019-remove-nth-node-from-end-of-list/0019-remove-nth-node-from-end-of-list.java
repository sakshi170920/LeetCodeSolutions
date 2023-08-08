/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int nthNode(ListNode head, int n)
    {
        if(head == null)
            return 0;
        int index = nthNode(head.next,n)+1;
        if(index == n+1)
        {
            System.out.println(head.val);
            head.next = head.next.next;
            return index;
        }
        return index;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = nthNode(head,n);
        if(index == n)
            return head.next;
        return head;
    }
}