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
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if(root.left!=null){
            if(root.left.left!=null||root.left.right!=null){
                result += sumOfLeftLeaves(root.left);
            }else{
                result += root.left.val;
            }
        }
        if(root.right!=null){
            if(root.right.left!=null||root.right.right!=null){
                result += sumOfLeftLeaves(root.right);
            }
        }
        return result;
    }
}