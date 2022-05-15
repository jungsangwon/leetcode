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
    public boolean isSymmetric(TreeNode root) {
        if(root.left!=null && root.right!=null){
            return isSymmetric(root.left,root.right);
        }else if(root.left==null && root.right==null){
            return true;
        }else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        boolean result = true;
        if(root1.left!=null && root2.right!=null){
            result = result && isSymmetric(root1.left,root2.right);
        }else if(root1.left==null && root2.right==null){
            
        }else{
            return false;
        }
        
        if(!result){
            return result;
        }
        
        if(root1.right!=null && root2.left!=null){
            result = result && isSymmetric(root1.right,root2.left);
        }else if(root1.right==null && root2.left==null){
            
        }else{
            return false;
        }
        if(!result){
            return result;
        }else{
            return root1.val == root2.val;            
        }
    }
}