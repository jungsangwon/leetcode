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
    TreeNode result = null;
    int max = -1;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        subtreeWithAllDeepest(root,0);
        return result;
    }
    
    public int subtreeWithAllDeepest(TreeNode root, int k) {
        if(root.left==null && root.right==null){
            if(k>max){
                result = root;
                max = k;
            }
            return k;
        }else{
            int left = 0;
            int right = 0;
            if(root.left!=null){
                left = subtreeWithAllDeepest(root.left,k+1);
            }
            if(root.right!=null){
                right = subtreeWithAllDeepest(root.right,k+1);
            }
            int now = Math.max(left,right);
            // System.out.println(root.val+" : "+left+" , "+right+" = "+max);
            if(left==right && left == max){
                result = root;
            }
            return now;
        }
    }
}