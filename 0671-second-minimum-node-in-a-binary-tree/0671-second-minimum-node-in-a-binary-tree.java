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
    public int findSecondMinimumValue(TreeNode root) {
        int[] min = new int[2];
        min[0] = -1;
        min[1] = -1;
        findSecondMinimumValue(root,min);
        return min[1];
    }
    
    public void findSecondMinimumValue(TreeNode root, int[] min) {
        if(min[0]==-1||min[0]>root.val){
            min[1] = min[0];
            min[0] = root.val;
        }else if(min[0]!=root.val && (min[1]==-1||min[1]>root.val)){
            min[1] = root.val;
        }
        if(root.left!=null){
            findSecondMinimumValue(root.left,min);
        }
        
        if(root.right!=null){
            findSecondMinimumValue(root.right,min);
        }
    }
}