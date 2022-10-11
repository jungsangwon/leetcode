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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int depth = 0;
        int count = 0;
        int now = 1;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            depth++;
            count += now;
            now *= 2;
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode tmp = qu.poll();
                if(tmp.left!=null){
                    qu.add(tmp.left);
                }
                if(tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
        }
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            list.add("");
        }
        for(int i=0; i<depth; i++){
            result.add(new ArrayList<>(list));
        }
        printTree(root,0,count-1,0,result);
        
        return result;
    }
    
    public void printTree(TreeNode root, int left, int right, int depth, List<List<String>> result){
        int idx = (left+right)/2;
        result.get(depth).set(idx,String.valueOf(root.val));
        if(root.left!=null){
            printTree(root.left,left,idx-1,depth+1,result);
        }
        if(root.right!=null){
            printTree(root.right,idx+1,right,depth+1,result);
        }
    }
}