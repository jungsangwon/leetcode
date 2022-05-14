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
    boolean isChange = false;
    public void recoverTree(TreeNode root) {
        if(root.left!=null){
            TreeNode tmp = getMax(root.left);
            if(tmp.val>root.val){
                TreeNode changeNode = root;
                if(root.right!=null){
                    TreeNode min = getMin(root.right);
                    if(min.val<changeNode.val){
                        changeNode = min;
                    }
                }
                int num = tmp.val;
                tmp.val = changeNode.val;
                changeNode.val = num;
                isChange = true;
            }
        }
        if(!isChange && root.right!=null){
            TreeNode tmp = getMin(root.right);
            if(tmp.val<root.val){
                System.out.println("3");
                int num = tmp.val;
                tmp.val = root.val;
                root.val = num;
                isChange = true;
            }
        }
        if(!isChange){
            if(root.left!=null){
                recoverTree(root.left);
            }
            if(root.right!=null){
                recoverTree(root.right);
            }
        }
    }
    
    public TreeNode getMax(TreeNode root){
        TreeNode max = root;
        if(root.left!=null){
            TreeNode tmp = getMax(root.left);
            if(tmp.val>max.val){
                max = tmp;
            }
        }
        if(root.right!=null){
            TreeNode tmp = getMax(root.right);
            if(tmp.val>max.val){
                max = tmp;
            }
        }
        return max;
    }
    
    public TreeNode getMin(TreeNode root){
        TreeNode min = root;
        if(root.left!=null){
            TreeNode tmp = getMin(root.left);
            if(tmp.val<min.val){
                min = tmp;
            }
        }
        if(root.right!=null){
            TreeNode tmp = getMin(root.right);
            if(tmp.val<min.val){
                min = tmp;
            }
        }
        return min;
    }
}