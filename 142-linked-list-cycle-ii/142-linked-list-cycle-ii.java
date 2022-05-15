/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();
        ListNode result = null;
        while(head!=null){
            if(map.contains(head)){
                return head;
            }else{
                map.add(head);
                head = head.next;
            }
        }    
        return result;
    }
}