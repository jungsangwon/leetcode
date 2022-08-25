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
    int min = Integer.MAX_VALUE;
    TreeNode pre;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null) min = Math.min(min, root.val - pre.val);
        pre = root;
        inorder(root.right);
    }
}