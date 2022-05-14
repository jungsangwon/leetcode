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
        ListNode result = new ListNode();
        ListNode now = result;
        int idx = 1;
        while(idx<left){
            now.next = head;
            head = head.next;
            now = now.next;
            idx++;
        }
        ListNode last = head;
        while(idx<=right){
            ListNode tmp = head.next;
            head.next = now.next;
            now.next = head;
            head = tmp;
            idx++;
        }
        now = last;
        while(head!=null){
            now.next = head;
            head = head.next;
            now = now.next;
            idx++;
        }
        now.next = null;
        return result.next;
    }
}