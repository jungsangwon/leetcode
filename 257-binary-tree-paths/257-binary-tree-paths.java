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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        binaryTreePaths(root,new StringBuilder(), result);
        return result;
    }
    
    public void binaryTreePaths(TreeNode root, StringBuilder now, List<String> result){
        now.append(root.val);
        if(root.left==null&&root.right==null){
            result.add(now.toString());
        }else{
            now.append("->");
            if(root.left!=null){
                binaryTreePaths(root.left,new StringBuilder(now), result);
            }
            if(root.right!=null){
                binaryTreePaths(root.right,new StringBuilder(now), result);
            }
        }
    }
}