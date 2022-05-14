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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode now = head;
        if(now == null){
            return head;
        }
        while(now.next!=null){
            now = now.next;
            len++;
        }
        now.next = head;
        len++;
        k=len-(k%len);
        for(int i=0; i<k-1; i++){
            head = head.next;
        }
        now = head.next;
        head.next = null;
        return now;
    }
}