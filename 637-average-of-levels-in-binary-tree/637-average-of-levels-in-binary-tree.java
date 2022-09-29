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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(!qu.isEmpty()){
            int size = qu.size();
            double sum = 0D;
            for(int i=0; i<size; i++){
                TreeNode now = qu.poll();
                sum += now.val;
                if(now.left!=null){
                    qu.add(now.left);
                }
                if(now.right!=null){
                    qu.add(now.right);
                }
            }
            sum = sum / size;
            result.add(sum);
        }
        
        return result;
    }
}