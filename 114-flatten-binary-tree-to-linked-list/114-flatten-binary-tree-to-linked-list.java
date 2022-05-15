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
    public void flatten(TreeNode root) {
        TreeNode left=null;
        TreeNode right=null;
        if(root!=null){
            if(root.left!=null){
                left = root.left;
                root.left = null;
            }
            if(root.right!=null){
                right = root.right;
                root.right=null;
            }
            root.right = left;
            flatten(left);
            if(right!=null){
                while(root.right!=null){
                    root = root.right;
                }
                root.right = right;
                flatten(right);
            }
        }
    }
}