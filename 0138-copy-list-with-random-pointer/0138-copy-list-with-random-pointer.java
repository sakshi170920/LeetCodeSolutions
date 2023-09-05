/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node temp1 = head,temp=head,temp2;
        while(temp1 != null)
        {
            temp = temp1.next;
            temp2 = new Node(temp1.val);
            temp1.next = temp2;
            temp2.next = temp;
            if(temp == null)
                break;
            temp1 = temp;
        }
        temp1=head;
        temp2=temp1.next;
        while(temp2 != null)
        {
            if(temp1.random == null)
                temp2.random = null;
            else
                temp2.random = temp1.random.next;
            if(temp2.next == null)
                break;
            temp1 = temp2.next;
            temp2 = temp1.next;
        }
        temp2 = head.next;
        temp1= head;
        temp = temp2;
        while(temp1 != null)
        {
            //System.out.println("curr : temp1 : "+temp1.val+" temp2 "+temp2.val);
            temp1.next = temp1.next.next;
            if(temp1.next == null)
            {
                temp2.next = null;
            }
            else
                temp2.next = temp1.next.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp;
    }
}