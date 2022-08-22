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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int result = 0;
        while(!qu.isEmpty()){
            result = qu.peek().val;
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode tmp = qu.poll();
                if(tmp.left!=null){
                    qu.add(tmp.left);
                }
                if(tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
        }
        return result;
    }
}