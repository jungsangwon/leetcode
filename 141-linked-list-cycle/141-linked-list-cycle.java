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
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        boolean result = false;
        int idx = 0;
        while(head!=null){
            if(map.containsKey(head)){
                return true;
            }else{
                map.put(head,idx);
                idx++;
                head = head.next;
            }
        }    
        return result;
    }
}