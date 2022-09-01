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
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int result = 0;
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                Node tmp = qu.poll();
                if(tmp.children!=null){
                    for(Node c : tmp.children){
                        qu.add(c);
                    }
                }
            }
            result++;
        }
        return result;
    }
}