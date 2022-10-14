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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        Queue<Long> idx = new LinkedList<>();
        qu.add(root);
        idx.add(1L);
        int result = 1;
        while(!qu.isEmpty()){
            Long min = Long.MAX_VALUE;
            Long max = Long.MIN_VALUE;
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode tmp = qu.poll();
                Long n = idx.poll();
                max = Math.max(max,n);
                min = Math.min(min,n);
                if(tmp.left!=null){
                    qu.add(tmp.left);
                    idx.add(n*2);
                }
                if(tmp.right!=null){
                    qu.add(tmp.right);
                    idx.add(n*2+1);
                }
            }
            result = Math.max(result,(int)(max-min+1));
        }
        
        return result;
    }
}