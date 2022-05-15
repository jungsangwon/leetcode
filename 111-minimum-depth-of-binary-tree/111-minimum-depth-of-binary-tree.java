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
    public int minDepth(TreeNode root) {
        int result = 0;
        Queue<TreeNode> qu = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if(root==null){
            return result;
        }else{
            next.add(root);
            boolean hasLeaf = false;
            while(true){
                result++;
                while(!next.isEmpty()){
                    TreeNode tmp = next.poll();
                    if(tmp.left==null&&tmp.right==null){
                        return result;
                    }else{
                        if(tmp.left!=null){
                            qu.add(tmp.left);
                        }
                        if(tmp.right!=null){
                            qu.add(tmp.right);
                        }
                    }
                }
                while(!qu.isEmpty()){
                    next.add(qu.poll());
                }
            }
        }
    }
}