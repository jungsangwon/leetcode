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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean result = false;
        if(root.val == subRoot.val){
            result = isEqual(root,subRoot);
        }
        if(root.left!=null){
            result = result || isSubtree(root.left,subRoot);
        }
        if(root.right!=null){
            result = result || isSubtree(root.right,subRoot);
        }
        return result;
    }
    
    public boolean isEqual(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }else if(root!=null && subRoot!=null){
            if(root.val!=subRoot.val){
                return false;
            }
            return isEqual(root.left,subRoot.left) && isEqual(root.right,subRoot.right);
        }else{
            return false;
        }
    }
}