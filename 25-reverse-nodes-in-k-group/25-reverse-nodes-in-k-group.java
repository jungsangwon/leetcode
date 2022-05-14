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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode nowNode = result;
        if(k==1){
            return head;
        }
        
        while(true){
            int len = getLen(head,k);
            if(len<k){
                for(int i=0; i<len; i++){
                    nowNode.next = head;
                    head = head.next;
                    nowNode = nowNode.next;
                } 
                break;
            }else{
                ListNode start = head;
                ListNode nextNode = head.next;
                for(int i=0; i<k; i++){
                    if(nowNode.next!=null){
                        nextNode = head.next;
                        head.next = nowNode.next;
                        nowNode.next=head;
                    }else{
                        nowNode.next=head;
                    }
                    head = nextNode;
                } 
                nowNode = start;
            }
            nowNode.next = null;
            ListNode tmp =result.next;
        }
        
        return result.next;
    }
    
    public int getLen(ListNode head, int k){
        int len = 0;
        ListNode tmp = head;
        for(int i=0; i<k; i++){
            if(tmp!=null){
                tmp = tmp.next;
            }else{
                break;
            }
            len++;
        }
        return len;
    }
}