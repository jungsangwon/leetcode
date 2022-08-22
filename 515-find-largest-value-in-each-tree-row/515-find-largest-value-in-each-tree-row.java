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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode tmp = qu.poll();
                if(tmp.left!=null){
                    qu.add(tmp.left);
                }
                if(tmp.right!=null){
                    qu.add(tmp.right);
                }
                if(max<tmp.val){
                    max = tmp.val;
                }
            }
            result.add(max);
        }
        
        return result;
    }
}