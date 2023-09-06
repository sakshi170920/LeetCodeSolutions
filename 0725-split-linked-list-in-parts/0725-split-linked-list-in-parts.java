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
    public int getLen(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int len = getLen(head);
        int batch = len/k;
        int rem = len%k;
        if(batch == 0){
            batch++;
            rem = 0;
        }
        ListNode temp = head;
        for(int i = 0;i<k;i++){
            res[i] = temp;
            if(temp == null){
                continue;
            } 
            int currBatch = batch + (rem-->0 ? 1 : 0);
            for(int j = 0;j<currBatch;j++){
                head = temp;
                temp = temp.next;
            }
            head.next = null;
        }
        return res;
    }
}