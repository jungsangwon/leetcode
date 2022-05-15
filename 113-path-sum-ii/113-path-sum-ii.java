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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
         if(root!=null){
             pathSum(root,targetSum,0,new ArrayList<>(),result);
        }
        return result;
    }
    
    public void pathSum(TreeNode root, int targetSum, int now, List<Integer> list, List<List<Integer>> result){
        if(root.left==null&&root.right==null){
            if((now + root.val) == targetSum){
                list.add(root.val);
                result.add(list);
            }
        }else{
            now = now + root.val;
            if(root.left!=null){
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(root.val);
                pathSum(root.left, targetSum, now, tmp, result);
            }
            if(root.right!=null){
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(root.val);
                pathSum(root.right, targetSum, now, tmp, result);
            }
        }
        
    }
}