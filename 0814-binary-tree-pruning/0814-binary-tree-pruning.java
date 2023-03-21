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
    public TreeNode pruneTree(TreeNode root) {
        if(isPruneTree(root)){
            return null;
        }else{
            if(root.left!=null){
                if(isPruneTree(root.left)){
                    root.left = null;
                }else{
                    pruneTree(root.left);
                }
            }
            if(root.right!=null){
                if(isPruneTree(root.right)){
                    root.right = null;
                }else{
                    pruneTree(root.right);
                }
            }
            return root;
        }
    }
    
    public boolean isPruneTree(TreeNode root){
        if(root.val == 1){
            return false;
        }else{
            boolean result = true;
            if(root.left!=null){
                result = result && isPruneTree(root.left);
            }
            if(!result){
                return result;
            }
            if(root.right!=null){
                result = result && isPruneTree(root.right);
            }
            return result;
        }
    }
}