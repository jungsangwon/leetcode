/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Node copyNode = new Node(node.val);
        HashMap<Integer,Node> map = new HashMap<>();
        map.put(node.val,copyNode);
        cloneGraph(copyNode,node.neighbors, map);
        return copyNode;
    }
    
    public void cloneGraph(Node node, List<Node> list, HashMap<Integer,Node> map) {
        for(Node tmp : list){
            if(!map.containsKey(tmp.val)){
                Node copyNode = new Node(tmp.val);
                map.put(tmp.val,copyNode);
                node.neighbors.add(copyNode);
                cloneGraph(copyNode,tmp.neighbors, map);
            }else{
                node.neighbors.add(map.get(tmp.val));
            }
        }
    }
}