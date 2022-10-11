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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right){
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=left; i<=right; i++){
            if(max<nums[i]){
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(nums[idx]);
        if(idx!=left){
            node.left = constructMaximumBinaryTree(nums,left,idx-1);
        }
        if(idx!=right){
            node.right = constructMaximumBinaryTree(nums,idx+1,right);
        }
        return node;
    }
}