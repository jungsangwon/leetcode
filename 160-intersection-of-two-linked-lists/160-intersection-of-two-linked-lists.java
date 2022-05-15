/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> map = new HashSet<>();
        while(true){
            if(headA == null && headB == null){
                return null;
            }
            
            if(headA!=null){
                if(map.contains(headA)){
                    return headA;
                }else{
                    map.add(headA);
                    headA = headA.next;
                }
            }
            
            if(headB!=null){
                if(map.contains(headB)){
                    return headB;
                }else{
                    map.add(headB);
                    headB = headB.next;
                }
            }
        }
    }
}