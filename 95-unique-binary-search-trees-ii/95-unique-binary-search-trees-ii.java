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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        result.add(root);
        for(int i=2; i<=n; i++){
            List<TreeNode> tmpList = new ArrayList<>();
            for(TreeNode node : result){
                TreeNode tmp = new TreeNode(i);
                TreeNode copyTree = copyTrees(node);
                tmp.left = copyTree;
                tmpList.add(tmp);
            }
            
            for(TreeNode node : result){
                TreeNode copyTree = copyTrees(node);
                TreeNode tmp = copyTree;
                int count = 0;
                while(tmp.right!=null){
                    TreeNode now = new TreeNode(i);
                    now.left = tmp.right;
                    tmp.right = now;
                    count++;
                    tmpList.add(copyTree);
                    copyTree = copyTrees(node);
                    tmp = copyTree;
                    for(int j=0; j<count; j++){
                        tmp = tmp.right;
                    }
                }
            }
            
            for(TreeNode node : result){
                while(node.right!=null){
                    node = node.right;
                }
                node.right = new TreeNode(i);
            }
            result.addAll(tmpList);
        }
        
        return result;
    }
    
    public TreeNode copyTrees(TreeNode root){
        TreeNode tree = new TreeNode(root.val);
        if(root.left!=null){
            tree.left = copyTrees(root.left);
        }
        if(root.right!=null){
            tree.right = copyTrees(root.right);
        }
        return tree;
    }
    
}