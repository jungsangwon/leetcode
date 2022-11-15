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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode node = root;
        while(true){
            if(node.val < val){
                if(node.right==null){
                    TreeNode add = new TreeNode(val);
                    node.right = add;
                    break;
                }else{
                    node = node.right;
                }
            }else{
                if(node.left==null){
                    TreeNode add = new TreeNode(val);
                    node.left = add;
                    break;
                }else{
                    node = node.left;
                }
            }
        }
        return root;
    }
}