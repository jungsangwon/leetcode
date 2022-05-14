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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nowNode = head;
        int size = 0;
        while(nowNode!=null){
            nowNode = nowNode.next;
            size ++;
        }
        if(size == 1){
            return null;
        }else if(size == n){
            return head.next;
        }else{
            nowNode = head;
            for(int i=0; i<size-n-1; i++){
                nowNode = nowNode.next;
            }
            nowNode.next = nowNode.next.next;
        }
        return head;
    }
}