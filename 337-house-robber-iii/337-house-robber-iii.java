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
    HashMap<TreeNode, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int max = 0;
        int next = 0;
        if(root.left!=null){
            max += rob(root.left); 
            if(root.left.left!=null){
                next += rob(root.left.left);
            }
            if(root.left.right!=null){
                next += rob(root.left.right);
            }
        }
        if(root.right!=null){
            max += rob(root.right);
            if(root.right.left!=null){
                next += rob(root.right.left);
            }
            if(root.right.right!=null){
                next += rob(root.right.right);
            }
        }
        max = Math.max(max,next+root.val);
        dp.put(root,max);
        
        return max;
    }
}