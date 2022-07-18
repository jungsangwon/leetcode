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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
 
        TreeNode curr = root;
 
        while (curr != null && curr.val != key)
        {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
 
        if (curr == null) {
            return root;
        }
 
        if (curr.left == null && curr.right == null)
        {
            if (curr != root)
            {
                if (parent.left == curr) {
                    parent.left = null;
                }else {
                    parent.right = null;
                }
            }else {
                root = null;
            }
        }else if (curr.left != null && curr.right != null)
        {
            TreeNode successor = getMinimumKey(curr.right);
            int val = successor.val;
            deleteNode(root, successor.val);
            curr.val = val;
        }else{
            TreeNode child = (curr.left != null)? curr.left: curr.right;
            if (curr != root)
            {
                if (curr == parent.left) {
                    parent.left = child;
                }else{
                    parent.right = child;
                }
            }else {
                root = child;
            }
        }
        return root;
    }
    
    public TreeNode getMinimumKey(TreeNode curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}