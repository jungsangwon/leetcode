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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null){
            return null;
        }
        int sum = 0;
        TreeNode left = null;
        TreeNode right = null;
        if(root1!=null && root2!=null){
            sum += (root1.val + root2.val);
            left = mergeTrees(root1.left,root2.left);
            right = mergeTrees(root1.right,root2.right);
        }else if(root1!=null){
            sum = root1.val;
            left = root1.left;
            right = root1.right;
        }else{
            sum = root2.val;
            left = root2.left;
            right = root2.right;
        }
        TreeNode result = new TreeNode(sum,left,right);
        
        return result;
    }
}