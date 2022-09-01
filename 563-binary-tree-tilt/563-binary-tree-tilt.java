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
    int sum = 0;
    public int findTilt(TreeNode root) {
        if(root!=null){
            findSum(root);
        }
        return sum;
    }
    
    public int findSum(TreeNode root){
        int left = 0;
        if(root.left!=null){
            left = findSum(root.left);
        }
        int right = 0;
        if(root.right!=null){
            right = findSum(root.right);
        }
        sum+=Math.abs(left-right);
        return left+right+root.val;
    }
}