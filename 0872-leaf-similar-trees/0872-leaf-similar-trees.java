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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        getLeaf(root1,leaf1);
        getLeaf(root2,leaf2);
        if(leaf1.size() != leaf2.size()){
            return false;
        }
        for(int i=0; i<leaf1.size(); i++){
            if(leaf1.get(i) != leaf2.get(i)){
                return false;
            }
        }
        
        return true;
    }
    
    public void getLeaf(TreeNode root, List<Integer> result){
        if(root.left==null && root.right==null){
            result.add(root.val);
        }
        if(root.left!=null){
            getLeaf(root.left,result);
        }
        if(root.right!=null){
            getLeaf(root.right,result);
        }
    }
}