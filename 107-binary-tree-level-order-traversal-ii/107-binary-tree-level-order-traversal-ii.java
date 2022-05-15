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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if(root==null){
            return result;
        }
        next.add(root);
        while(true){
            List<Integer> tmp = new ArrayList<>();
            while(!next.isEmpty()){
                TreeNode node = next.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    qu.add(node.left);
                }
                if(node.right!=null){
                    qu.add(node.right);
                }
            }
            result.add(0,tmp);
            if(!qu.isEmpty()){
                while(!qu.isEmpty()){
                    next.add(qu.poll());
                }
            }else{
                break;
            }
        }
        
        return result;
    }
}