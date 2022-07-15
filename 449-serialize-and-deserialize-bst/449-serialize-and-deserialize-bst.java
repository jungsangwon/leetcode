/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        qu.add(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode node = qu.poll();
                if(node == null){
                    sb.append("null");
                    sb.append(",");
                }else{
                    sb.append(node.val);
                    sb.append(",");
                    qu.add(node.left);
                    qu.add(node.right);
                }
            }
        }
        return sb.substring(0,sb.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] str = data.split(",");
        Queue<TreeNode> qu = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        qu.add(root);
        int idx = 1;
        while(idx<str.length){
            TreeNode node = qu.poll();
            if(str[idx].equals("null")){
                idx++;
                node.left = null;
            }else{
                TreeNode left = new TreeNode(Integer.parseInt(str[idx++]));
                node.left = left;
                qu.add(left);
            }
            if(idx<str.length){
                if(str[idx].equals("null")){
                    idx++;
                    node.right = null;
                }else{
                    TreeNode right = new TreeNode(Integer.parseInt(str[idx++]));
                    node.right = right;
                    qu.add(right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;