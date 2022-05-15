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
    public int maxDepth(TreeNode root) {
        int result = 0;
        if(root==null){
            return result;
        }else{
            if(root.left==null && root.right==null){
                return 1;
            }
            if(root.left!=null){
                result = Math.max(result,maxDepth(root.left));
            }
            if(root.right!=null){
                result = Math.max(result,maxDepth(root.right));
            }
        }
        return result+1;
    }
}