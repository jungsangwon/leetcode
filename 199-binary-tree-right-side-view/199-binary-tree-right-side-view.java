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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            int right = 0;
            for(int i=0; i<size; i++){
                TreeNode tmp = qu.poll();
                right = tmp.val;
                if(tmp.left!=null){
                    qu.add(tmp.left);
                }
                if(tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
            result.add(right);
        }
        
        return result;
    }
}