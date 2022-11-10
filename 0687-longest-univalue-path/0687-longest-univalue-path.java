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
    int result = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root!=null){
            getLongestUnivaluePath(root);
        }
        return result;
    }
    
    public int getLongestUnivaluePath(TreeNode root) {
        int len = 1;
        int max = 0;
        int left = 0;
        int right = 0;
        if(root.left!=null){
            left = getLongestUnivaluePath(root.left);
            if(root.left.val==root.val){
                max += left;
                len = left+1;
            }
        }
        if(root.right!=null){
            right = getLongestUnivaluePath(root.right);
            if(root.right.val==root.val){
                max += right;
                len = Math.max(len,right+1);
            }
        }
        result = Math.max(result,max);
        return len;
    }
}