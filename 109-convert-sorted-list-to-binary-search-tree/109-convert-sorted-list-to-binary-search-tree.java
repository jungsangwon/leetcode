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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head = head.next;
        }
        Integer[] nums = arr.toArray(new Integer[arr.size()]);
        int mid = nums.length / 2;
        if(nums.length==0){
            return null;
        }
        TreeNode root = new TreeNode(nums[mid]);
        sortedArrayToBST(root,0,nums.length-1,mid,nums);
        return root;
    }
    
    public void sortedArrayToBST(TreeNode root, int start, int end, int mid, Integer[] nums){
        // System.out.println(start+"~"+end+" . "+mid);
        if(start<mid){
            int tmid = start + (mid-start)/2;
            TreeNode tmp = new TreeNode(nums[tmid]);
            root.left = tmp;
            sortedArrayToBST(tmp,start,mid-1,tmid,nums);
        }
        if(end>mid){
            int tmid = mid + ((end-mid)/2)+ ((end-mid)%2);
            TreeNode tmp = new TreeNode(nums[tmid]);
            root.right = tmp;
            sortedArrayToBST(tmp,mid+1,end,tmid,nums);
        }
    }
}