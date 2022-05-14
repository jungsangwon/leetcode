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
    public boolean isValidBST(TreeNode root) {
        boolean result = true;
        if(root.left==null && root.right==null){
            return result;
        }
        if(root.left!=null){
            result = result && getMax(root.left)<root.val && isValidBST(root.left);
        }
        if(root.right!=null){
            result = result && getMin(root.right)>root.val && isValidBST(root.right);
        }
        return result;
    }
    
    public int getMin(TreeNode root) {
        while(root.left!=null){
            root = root.left;
        }
        return root.val;
    }
    
    public int getMax(TreeNode root) {
        while(root.right!=null){
            root = root.right;
        }
        return root.val;
    }
}