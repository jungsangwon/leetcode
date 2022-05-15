/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<TreeNode> p_ancestor = new HashSet<>();
        HashSet<TreeNode> q_ancestor = new HashSet<>();
        getAncestor(root,p,p_ancestor);
        getAncestor(root,q,q_ancestor);
        while(true){
            if(root.left!=null){
                if(p_ancestor.contains(root.left)&&q_ancestor.contains(root.left)){
                    root=root.left;
                    continue;
                }else if(root.right!=null){
                    if(p_ancestor.contains(root.right)&&q_ancestor.contains(root.right)){
                        root=root.right;
                        continue;
                    }
                }
            }else{
                if(p_ancestor.contains(root.right)&&q_ancestor.contains(root.right)){
                    root=root.right;
                    continue;
                }
            }
            return root;
        }
    }
    
    public boolean getAncestor(TreeNode root, TreeNode target, HashSet<TreeNode> ancestor){
        if(root == target){
            ancestor.add(root);
            return true;
        }else{
            if(root.left!=null){
                if(getAncestor(root.left,target,ancestor)){
                    ancestor.add(root);
                    return true;
                }else if(root.right!=null){
                    if(getAncestor(root.right,target,ancestor)){
                        ancestor.add(root);
                        return true;
                    }
                }
            }else if(root.right!=null){
                if(getAncestor(root.right,target,ancestor)){
                    ancestor.add(root);
                    return true;
                }
            }
        }
        return false;
    }
}