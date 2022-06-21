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
    HashSet<ListNode> hashSet;
    
    public Solution(ListNode head) {
        hashSet = new HashSet<>();
        while(head!=null){
            hashSet.add(head);
            head = head.next;
        }
    }
    
    public int getRandom() {
        Random random = new Random();
        List<ListNode> list = new ArrayList<>(hashSet);
        return list.get(random.nextInt(list.size())).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */