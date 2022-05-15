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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        int len = postorder.length-1;
        int idx = len;
        TreeNode root = new TreeNode(postorder[len]);
        st.push(root);
        map.put(postorder[len],1);
        TreeNode now = root;
        int mode = 1;
        for(int i=len-1; i>=0; i--){
            if(map.containsKey(inorder[idx])){
                now = st.pop();
                idx--;
                i++;
                mode=2;
            }else{
                TreeNode node = new TreeNode(postorder[i]);
                map.put(postorder[i],1);
                st.push(node);
                if(mode==1){
                    now.right = node;
                }else{
                    now.left = node;
                    mode=1;
                }
                now = node;
            }
        }
        return root;
    }
}