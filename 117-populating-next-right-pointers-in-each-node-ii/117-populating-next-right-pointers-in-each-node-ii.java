/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> qu = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();
        if(root==null){
            return root;
        }
        
        next.add(root);
        while(true){
            Node first = next.poll();
            if(first.left!=null){
                qu.add(first.left);
            }
            if(first.right!=null){
                qu.add(first.right);
            }
            while(!next.isEmpty()){
                Node tmp = next.poll();
                first.next= tmp;
                first = tmp;
                if(tmp.left!=null){
                    qu.add(tmp.left);
                }
                if(tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
            
            
            if(qu.isEmpty()){
                break;
            }else{
                while(!qu.isEmpty()){
                    next.add(qu.poll());
                }
            }
        }
        return root;
        
    }
}