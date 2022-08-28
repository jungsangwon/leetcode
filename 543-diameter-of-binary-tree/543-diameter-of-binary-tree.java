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
    public int diameterOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode tmp = qu.poll();
            int left = 0;
            int right = 0;
            if(tmp.left!=null){
                qu.add(tmp.left);
                left = getDistance(tmp.left)+1;
            }
            if(tmp.right!=null){
                qu.add(tmp.right);
                right = getDistance(tmp.right)+1;
            }
            max = Math.max(max,left+right);
        }
        return max;
    }
    
    public int getDistance(TreeNode root){
        int result = 0;
        if(root.left!=null){
            result = getDistance(root.left)+1;
        }
        if(root.right!=null){
            result = Math.max(result,getDistance(root.right)+1);
        }
        return result;
    }
}