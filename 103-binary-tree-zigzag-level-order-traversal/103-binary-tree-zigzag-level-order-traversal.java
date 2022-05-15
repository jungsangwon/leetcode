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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        if(root==null){
            return result;
        }
        qu.add(root);
        int mode = -1;
        while(true){
            List<Integer> tmp = new ArrayList<>();
            while(!qu.isEmpty()){
                TreeNode node = qu.poll();
                tmp.add(node.val);
                addNext(nextLevel,mode,node);
            }
            result.add(tmp);
            mode *= -1;
            if(nextLevel.isEmpty()){
                break;
            }else{
                while(!nextLevel.isEmpty()){
                    qu.add(nextLevel.pop());
                }
            }
        }
        return result;
    }
    
    public void addNext(Stack<TreeNode> nextLevel, int mode, TreeNode node){
        if(mode==1){
            if(node.right!=null){
                nextLevel.push(node.right);
            }
            if(node.left!=null){
                nextLevel.push(node.left);
            }
        }else{
            if(node.left!=null){
                nextLevel.push(node.left);
            }
            if(node.right!=null){
                nextLevel.push(node.right);
            }
        }
    }
}