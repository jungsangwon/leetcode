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
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        sortedArrayToBST(root,0,nums.length-1,mid,nums);
        return root;
    }
    
    public void sortedArrayToBST(TreeNode root, int start, int end, int mid, int[] nums){
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