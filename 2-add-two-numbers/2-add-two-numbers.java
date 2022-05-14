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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstAdd = l1.val + l2.val;  
        int up = firstAdd / 10;
        ListNode result = new ListNode(firstAdd%10);
        ListNode nowNode = result;
        ListNode nextNode = null;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null || up != 0){
            int tmp = up;
            if(l1 != null){
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                tmp += l2.val;
                l2 = l2.next;
            }
            nextNode = new ListNode(tmp%10);
            nowNode.next = nextNode;
                
            nowNode = nextNode;
            nextNode = null;
            up = tmp / 10;
        }
        return result;
    }
}