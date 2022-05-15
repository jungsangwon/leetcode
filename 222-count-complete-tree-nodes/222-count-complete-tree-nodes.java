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
    public int countNodes(TreeNode root) {
        int result = 1;
        if(root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left!=null){
            result += countNodes(root.left);
        }
        if(root.right!=null){
            result += countNodes(root.right);
        }
        return result;
    }
}