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
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        int now = 1;
        if(head.val%2==1){
            now *=-1;
        }
        ListNode to = odd;
        ListNode te = even;
        int tn = now;
        while(head!=null){
            if(tn==1){
                te.next = head;
                te = te.next;
            }else{
                to.next = head;
                to = to.next;
            }
            head = head.next;
            tn *=-1;
        }
        if(now ==1){
            te.next = odd.next;
            to.next=null;
            return even.next;
        }else{
            to.next = even.next;
            te.next=null;
            return odd.next;
        }
    }
}