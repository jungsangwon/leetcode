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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode t = new TreeNode(val);
            t.left = root;
            return t;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(depth>2){
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode t = qu.poll();
                if(t.left!=null){
                    qu.add(t.left);
                }
                if(t.right!=null){
                    qu.add(t.right);
                }
            }
            depth--;
        }
        for(TreeNode node : qu){
            TreeNode l = new TreeNode(val);
            if(node.left!=null){
                l.left = node.left;
                
            }
            node.left = l;
            TreeNode r = new TreeNode(val);
            if(node.right!=null){
                r.right = node.right;
                
            }
            node.right = r;
        }
        return root;
    }
}