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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    public int sumNumbers(TreeNode root, int now) {
        int result = 0;
        int tmp = (now*10) + root.val;
        if(root.left==null && root.right==null){
            return tmp;
        }
        if(root.left!=null){
            result += sumNumbers(root.left,tmp);
        }
        if(root.right!=null){
            result += sumNumbers(root.right,tmp);
        }
        return result;
    }
}