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
    int result = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        minBST(root);
        return result;
    }
    
    public int[] minBST(TreeNode root){
        int[] num = new int[2];
        num[0] = root.val;
        num[1] = root.val;
        if(root.left != null || root.right != null){
            int[] left;
            int[] right;
            if(root.left!=null){
                left = minBST(root.left);
                num[0] = left[0];
                result = Math.min(result,root.val-left[1]);
            }
            if(root.right!=null){
                right = minBST(root.right);
                num[1] = right[1];
                result = Math.min(result,right[0]-root.val);
            }
            
        }
        return num;
    }
}