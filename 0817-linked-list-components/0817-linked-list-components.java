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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hashSet.add(nums[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while(head!=null){
            if(hashSet.contains(head.val)){
                list.add(idx);
            }
            idx++;
            head = head.next;
        }
        
        Collections.sort(list);
        int before = -2;
        int result = 0;
        for(int a : list){
            if(before+1!=a){
                result++;
            }
            before =a;
        }
        return result;
    }
}