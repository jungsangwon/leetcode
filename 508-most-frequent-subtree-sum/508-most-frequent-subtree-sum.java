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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> count = new HashMap<>();
        findFrequentTreeSum(root,count);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int key : count.keySet()){
            if(max==count.get(key)){
                list.add(key);
            }else if(max<count.get(key)){
                max = count.get(key);
                list = new ArrayList<>();
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public int findFrequentTreeSum(TreeNode root, HashMap<Integer,Integer> count) {
        int sum = root.val;
        if(root.left != null){
            sum += findFrequentTreeSum(root.left,count);
        }
        if(root.right != null){
            sum += findFrequentTreeSum(root.right,count);
        }
        count.put(sum,count.getOrDefault(sum,0)+1);
        return sum;
    }
}