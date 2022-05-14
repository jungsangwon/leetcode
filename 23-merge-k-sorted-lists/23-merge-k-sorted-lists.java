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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode nowNode = head;
        int now = Integer.MIN_VALUE;
        while(true){
            int min = Integer.MAX_VALUE;
            int idx = -1;
            int check = 0;
            for(int i=0; i<lists.length; i++){
                if(lists[i]!=null){
                    if(now==lists[i].val){
                        nowNode.next = lists[i];
                        lists[i] = lists[i].next;
                        nowNode = nowNode.next;
                        i--;
                    }else if(min>lists[i].val){
                        min = lists[i].val;
                        idx = i;
                    }
                }else{
                    check++;
                }
            }
            if(check==lists.length){
                break;
            }
            nowNode.next = lists[idx];
            now = lists[idx].val;
            lists[idx] = lists[idx].next;
            nowNode = nowNode.next;
        }
        
        return head.next;
    }
}