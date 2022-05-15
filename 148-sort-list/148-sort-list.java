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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int len = 0;
        ListNode now = head;
        while(head!=null){
            len++;
            head = head.next;
        }
        
        return separate(now,len);
    }
    
    public ListNode separate(ListNode head, int len){
        if(head.next == null||head==null){
            return head;
        }else{
            int nextLen = len/2;
            ListNode before = head;
            for(int i=0; i<nextLen-1; i++){
                before = before.next;
            }
            ListNode next = before.next;
            before.next = null;
            ListNode node1 = separate(head,nextLen);
            ListNode node2 = separate(next,len-nextLen);
            return mergeNode(node1, node2);
        }
    }
    
    public ListNode mergeNode(ListNode node1, ListNode node2){
        ListNode result = new ListNode();
        ListNode now = result;
        while(node1!=null&&node2!=null){
            if(node1.val<node2.val){
                now.next = node1;
                node1 = node1.next;
                now = now.next;
                now.next = null;
            }else{
                now.next = node2;
                node2 = node2.next;
                now = now.next;
                now.next = null;
            }
        }
        if(node1!=null){
            now.next=node1;
        }else{
            now.next=node2;
        }
        return result.next;
    }
    
}