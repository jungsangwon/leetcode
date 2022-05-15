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
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        if(head==null){
            return head;
        }else{
            while(head!=null){
                ListNode tmp = result.next;
                result.next = head;
                head = head.next;
                result.next.next = tmp;
            }
        }
        return result.next;
    }
}