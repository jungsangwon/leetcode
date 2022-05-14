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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode more = new ListNode();
        ListNode tmp = more;
        ListNode result = less;
        while(head!=null){
            if(head.val>=x){
                more.next = head;
                more = more.next;
            }else{
                less.next = head;
                less = less.next;
            }
            head = head.next;
        }
        
        less.next = null;
        more.next = null;
        
        if(tmp.next!=null){
            less.next = tmp.next;
        }
        
        return result.next;
    }
}