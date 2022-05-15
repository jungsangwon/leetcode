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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        if(root==null){
            return result;
        }
        qu.add(root);
        while(true){
            List<Integer> tmp = new ArrayList<>();
            while(!qu.isEmpty()){
                TreeNode node = qu.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    nextLevel.add(node.left);
                }
                if(node.right!=null){
                    nextLevel.add(node.right);
                }
            }
            result.add(tmp);
            if(nextLevel.isEmpty()){
                break;
            }else{
                while(!nextLevel.isEmpty()){
                    qu.add(nextLevel.poll());
                }
            }
        }
        return result;
    }
}