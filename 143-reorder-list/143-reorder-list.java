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
    public void reorderList(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        int idx = 0;
        ListNode now =head;
        while(now!=null){
            map.put(idx++,now);
            now = now.next;
        }
        now = head;
        idx--;
        int len = idx/2;
        boolean last  = idx%2 == 1;
        for(int i=0; i<len; i++){
            ListNode tmp = now.next;
            now.next = map.get(idx--);
            now = now.next;
            now.next = tmp;
            now = tmp;
        }
        if(last){
            now.next = map.get(idx);
            now = now.next;
        }
        now.next = null;
    }
}