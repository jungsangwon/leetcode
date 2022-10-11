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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,List<TreeNode>> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtrees(root,map);
        for(String key : map.keySet()){
            List<TreeNode> list = map.get(key);
            if(list.size()>1){
                result.add(list.get(0));
            }
        }
        return result;
    }
    
    public String findDuplicateSubtrees(TreeNode node, HashMap<String,List<TreeNode>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        if(node.left!=null){
            sb.append(",");
            sb.append(findDuplicateSubtrees(node.left,map));
        }else{
            sb.append(",n");
        }
        if(node.right!=null){
            sb.append(",");
            sb.append(findDuplicateSubtrees(node.right,map));
        }else{
            sb.append(",n");
        }
        List<TreeNode> list = map.getOrDefault(sb.toString(),new ArrayList<>());
        list.add(node);
        map.put(sb.toString(),list);
        return sb.toString();
    }
}