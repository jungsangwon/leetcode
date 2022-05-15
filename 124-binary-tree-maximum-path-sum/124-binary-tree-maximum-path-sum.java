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
    public int maxPathSum(TreeNode root) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        getMaxPath(root,pq);
        return pq.poll();
    }
    
    public int getMaxPath(TreeNode root, PriorityQueue<Integer> pq){
        int left = 0;
        int right = 0;
        int sum = root.val;
        if(root.left!=null){
            left = Math.max(left,getMaxPath(root.left,pq));
        }
        if(root.right!=null){
            right = Math.max(right,getMaxPath(root.right,pq));
        }
        sum += Math.max(left,right);
        pq.add(left+right+root.val);
        return sum;
        
    }
}