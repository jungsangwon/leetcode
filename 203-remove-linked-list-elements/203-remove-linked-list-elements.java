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
        ListNode result = new ListNode();
        ListNode tmp = result;
        while(head!=null){
            if(head.val != val){
                result.next = head;
                result=result.next;
            }
            head = head.next;
        }
        result.next = null;
        return tmp.next;
    }
}