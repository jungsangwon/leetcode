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
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        while(l1!=null){
            st1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            st2.push(l2);
            l2 = l2.next;
        }
        int up = 0;
        ListNode next = null;
        while(!st1.isEmpty()&&!st2.isEmpty()){
            int sum = st1.pop().val + st2.pop().val + up;
            up = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            node.next = next;
            next = node;
        }
        while(!st1.isEmpty()){
            int sum = st1.pop().val + up;
            up = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            node.next = next;
            next = node;
        }
        while(!st2.isEmpty()){
            int sum = st2.pop().val + up;
            up = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            node.next = next;
            next = node;
        }
        if(up!=0){
            ListNode node = new ListNode(up);
            node.next = next;
            next = node;
        }
        return next;
    }
}