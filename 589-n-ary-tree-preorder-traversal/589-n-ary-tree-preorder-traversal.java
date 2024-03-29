/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            preorder(root,result);
        }
        return result;
    }
    
    public void preorder(Node root, List<Integer> result){
        result.add(root.val);
        for(Node child : root.children){
            preorder(child,result);
        }
    }
}