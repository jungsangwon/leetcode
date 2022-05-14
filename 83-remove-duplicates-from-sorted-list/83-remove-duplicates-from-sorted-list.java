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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode();
        ListNode now = result;
        while(head!=null){
            if(head.next == null){
                now.next = head;
                now = now.next;
                head = head.next;
            }else{
                if(head.next.val == head.val){
                    while(head.next!=null&&head.next.val==head.val){
                        head = head.next;
                    }
                }else{
                    now.next = head;
                    now = now.next;
                    head = head.next;
                }
            }
        }
        now.next = null;
        return result.next;
    }
}