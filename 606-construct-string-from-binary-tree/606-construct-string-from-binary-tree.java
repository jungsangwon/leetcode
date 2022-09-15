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
    public String tree2str(TreeNode root) {
        String result = "";
        if(root==null){
            return result;
        }
        result += root.val;
        if(root.left!=null){
            result += "(";
            result += tree2str(root.left);
            result += ")";
        }
        if(root.right!=null){
            if(root.left==null){
                result += "()";
            }
            result += "(";
            result += tree2str(root.right);
            result += ")";
        }
        return result;
    }
}