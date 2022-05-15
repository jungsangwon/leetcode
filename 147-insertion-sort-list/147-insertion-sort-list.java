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
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode();
        if(head == null){
            return head;
        }else{
            ListNode tmp = head.next;
            result.next = head;
            head.next = null;
            head = tmp;
        }
        // printNode(result.next);
        while(head!=null){
            ListNode before = result;
            ListNode now = result.next;
            while(now!=null){
                if(now.val>=head.val){
                    ListNode tmp = head.next;
                    before.next = head;
                    head.next =now;
                    head = tmp;
                    break;
                }else{
                    before = now;
                    now = now.next;
                }
            }
            if(now==null){
                ListNode tmp = head.next;
                before.next = head;
                head.next =now;
                head = tmp;
            }
        }
        
        return result.next;
    }
    
    // public void printNode(ListNode head){
    //     while(head!=null){
    //         System.out.print(head.val+ " -> ");
    //         head = head.next;
    //     }
    //     System.out.println("");
    //     System.out.println("=======");
    // }
}