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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return hasPathSum(root,targetSum,0);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum, int now){
        boolean result = false;
        if(root.left==null&&root.right==null){
            return (now + root.val) == targetSum;
        }else{
            now = now + root.val;
            if(root.left!=null){
                result = result || hasPathSum(root.left, targetSum, now);
            }
            if(root.right!=null){
                result = result || hasPathSum(root.right, targetSum, now);
            }
            return result;
        }
        
    }
}