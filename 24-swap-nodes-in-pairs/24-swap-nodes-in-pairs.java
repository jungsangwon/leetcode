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
    public ListNode swapPairs(ListNode head) {
        ListNode nowNode = head;
        ListNode preNode = null;
        if(head!=null && head.next!=null){
            head = head.next;
        }
        while(nowNode!=null && nowNode.next!=null){
            if(preNode!=null){
                preNode.next = nowNode.next;
            }
            ListNode nextNode = nowNode.next;
            nowNode.next = nextNode.next;
            nextNode.next = nowNode;
            preNode = nowNode;
            nowNode = nextNode.next.next;
        }
        return head;
    }
}