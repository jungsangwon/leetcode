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
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while(tmp!=null){
            size++;
            tmp = tmp.next;
        }
        size/=2;
        for(int i=0; i<size; i++){
            head = head.next;
        }
        return head;
    }
}