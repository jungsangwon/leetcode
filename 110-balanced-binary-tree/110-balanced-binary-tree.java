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
    public boolean isBalanced(TreeNode root) {
        int left = 0;
        int right = 0;
        if(root==null){
            return true;
        }
        if(root.left!=null){
            left = getDepth(root.left);
        }
        if(root.right!=null){
            right = getDepth(root.right);
        }
        if(left==-1||right==-1){
            return false;
        }
        if(left-right<-1||left-right>1){
            return false;
        }else{
            return true;
        }
    }
    public int getDepth(TreeNode node){
        if(node.left==null&&node.right==null){
            return 1;
        }else{
            int left = 0;
            int right =0;
            if(node.left!=null){
                left = getDepth(node.left);
            }
            if(node.right!=null){
                right = getDepth(node.right);
            }
            if(left==-1||right==-1){
                return -1;
            }
            if(left-right<-1||left-right>1){
                return -1;
            }else{
                return Math.max(left,right)+1;
            }
        }
    }
}