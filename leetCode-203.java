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
    public ListNode removeElements(ListNode head, int val) {
       ListNode newHead=new ListNode(0);
       ListNode preNode=newHead;
       ListNode temp=head;
       while(temp!=null){
        if(temp.val!=val){
            preNode.next=temp;
            temp=temp.next;
            preNode=preNode.next;
            preNode.next=null;
        }else{
            temp=temp.next;
        }
       }
       return newHead.next;
    }
}