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
class BSTIterator {
    Stack<TreeNode> st;
    TreeNode now;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        while(root!=null){
            st.push(root);
            root = root.left;
        }
        now = st.pop();
    }
    
    public int next() {
        int tmp = now.val;
        if(now.right!=null){
            now = now.right;
            while(now!=null){
                st.push(now);
                now = now.left;
            }
            now = st.pop();
        }else if(!st.isEmpty()){
            now = st.pop();
        }else{
            now = null;
        }
        return tmp;
    }
    
    public boolean hasNext() {
        return !st.isEmpty() || now!=null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */