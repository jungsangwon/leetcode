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
    public int pathSum(TreeNode root, int targetSum) {
        int result = 0;
        if(root!=null){
            result = pathSum(root,targetSum,0);
            if(root.left!=null){
                result += pathSum(root.left,targetSum);
            }
            if(root.right!=null){
                result += pathSum(root.right,targetSum);
            }
        }
        return result;
    }
    
    public int pathSum(TreeNode root, int targetSum, int sum) {
        int count = 0;
        sum+=root.val;
        if(targetSum == sum){
            count++;
        }
        if(root.left!=null){
            count += pathSum(root.left,targetSum,sum);
        }
        if(root.right!=null){
            count += pathSum(root.right,targetSum,sum);
        }
        return count;
    }
}