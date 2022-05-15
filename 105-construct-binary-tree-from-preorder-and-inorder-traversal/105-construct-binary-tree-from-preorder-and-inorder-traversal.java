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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        int len = preorder.length;
        int idx = 0;
        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);
        map.put(preorder[0],1);
        TreeNode now = root;
        int mode = 1;
        for(int i=1; i<len; i++){
            if(map.containsKey(inorder[idx])){
                now = st.pop();
                idx++;
                i--;
                mode=2;
            }else{
                TreeNode node = new TreeNode(preorder[i]);
                map.put(preorder[i],1);
                st.push(node);
                if(mode==1){
                    now.left = node;
                }else{
                    now.right = node;
                    mode=1;
                }
                now = node;
            }
        }
        return root;
    }
}