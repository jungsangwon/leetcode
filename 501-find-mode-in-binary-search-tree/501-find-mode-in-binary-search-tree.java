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
    List<Integer> list = new ArrayList<>();
    int max = 1;
    int now = 0;
    int pre = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        inorder(root);
        if(max==now){
            list.add(pre);
        }else if(max<now){
            list = new ArrayList<>();
            max = now;
            list.add(pre);
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public void inorder(TreeNode root){
        if(root.left!=null){
            inorder(root.left);
        }
        if(pre == root.val){
            now++;
        }else{
            if(max==now){
                list.add(pre);
            }else if(max<now){
                list = new ArrayList<>();
                max = now;
                list.add(pre);
            }
            now = 1;
            pre = root.val;
        }
        if(root.right!=null){
            inorder(root.right);
        }
    }
}