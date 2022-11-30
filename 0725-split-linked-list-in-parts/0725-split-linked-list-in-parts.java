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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len=0;
        ListNode[] result = new ListNode[k];
        ListNode node = head;
        while(node!=null){
            len++;
            node = node.next;
        }
        int distance = len/k;
        int rest = len%k;
        for(int i=0;i<k;i++){
            if(head==null){
                break;
            }
            result[i] = head;
            int limit = distance+-1;
            if(rest>0){
                limit++;
                rest--;
            }
            for(int j=0; j<limit; j++){
                head = head.next;
            }
            
            ListNode now = head;
            head = head.next;
            now.next=null;
        }
        return result;
    }
}