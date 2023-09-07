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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right)
            return head;
        ListNode res = head;
        ListNode prev = null;
        int count = 1;
        while(head != null && count<left){
            prev = head;
            head = head.next;
            count++;
        }
        //System.out.println("prev "+prev.val+" head "+head.val);
        // found the start now reverse till right
        ListNode p = head;
        if(head == null)
            return res;
        ListNode q = p.next,r;
        while(q != null && count < right){
            r = q.next;
            q.next = p;
            p = q;
            q = r; 
            count++;
        }
        if(prev != null){
            prev.next = p;
        }
        else{
            res.next = null;
            res = p;
        }
        head.next = q;
        return res;
    }
}