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
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> qu = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode tmp = qu.poll();
                if(hashSet.contains(k-tmp.val)){
                    return true;
                }
                hashSet.add(tmp.val);
                if(tmp.left!=null){
                    qu.add(tmp.left);
                }
                if(tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
        }
        return false;
    }
}